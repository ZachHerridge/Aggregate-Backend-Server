package com.mhack.aggregate.server.api.user;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.google.gson.Gson;
import com.mhack.aggregate.server.api.user.domain.profile.Profile;
import com.mhack.aggregate.server.api.user.domain.User;
import com.mhack.aggregate.server.database.arango.DBArango;
import com.mhack.aggregate.server.jwt.JwtUtil;
import spark.Spark;

import java.util.Collections;

public class UserAPI {

    private static Gson gson = new Gson();
    private static ArangoCollection users = DBArango.getDb().collection("users");

    public static User getUserById(String userId) {
        return users.getDocument(userId, User.class);
    }

    public static User getUserByDisplayName(String displayName) {
        ArangoCursor<User> query = users.db().query(
                "FOR u IN users\n" +
                        "FILTER u.displayName == @displayName\n" +
                        "LIMIT 1\n" +
                        "RETURN u ",
                Collections.singletonMap("displayName", displayName), User.class);
        return query.hasNext() ? query.next() : null;
    }

    public static void init() {
        Spark.put("/user/profile", (req, res) -> {
            try {
                String userId = JwtUtil.decodeToId(req.headers("jwt"));
                if (userId != null){
                    User userById = getUserById(userId);
                    userById.setProfile(gson.fromJson(req.body(), Profile.class));
                    users.updateDocument(userId, userById);
                    return "OK";
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw e;
            }
            return "FAIL";
        });

        Spark.get("/user", (req, res) -> {
            try {
                String userId = JwtUtil.decodeToId(req.headers("jwt"));
                if (userId != null){
                    return gson.toJson(getUserById(userId));
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw e;
            }
            return "FAIL";
        });

        Spark.get("/user/profile", (req, res) -> {
            try {
                String userId = JwtUtil.decodeToId(req.headers("jwt"));
                if (userId != null){
                    return gson.toJson(getUserById(userId).getProfile());
                }
            } catch (Throwable e) {
                e.printStackTrace();
                throw e;
            }
            return "FAIL";
        });

        Spark.get("/login", (req, res) -> {
            String displayName = req.queryParams("displayName");
            String password = req.queryParams("password");
            User userByDisplayName = getUserByDisplayName(displayName);
            if (userByDisplayName != null && userByDisplayName.getPassword().equals(password)) {
                return "OK " + JwtUtil.create(userByDisplayName) + " " + userByDisplayName.get_Key();
            }
            return "FAIL";
        });


    }
}

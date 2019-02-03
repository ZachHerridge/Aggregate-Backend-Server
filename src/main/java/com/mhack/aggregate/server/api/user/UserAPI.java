package com.mhack.aggregate.server.api.user;

import com.arangodb.ArangoCollection;
import com.google.gson.Gson;
import com.mhack.aggregate.server.api.user.domain.User;
import com.mhack.aggregate.server.database.arango.DBArango;
import spark.Spark;

public class UserAPI {



    public static void init(){
        Gson gson = new Gson();
        ArangoCollection users = DBArango.getDb().collection("users");

        Spark.get("/user/:userId/profile", (req, res) -> {
            String userId = req.params("userId");
            try {
                User document = users.getDocument(userId, User.class);
                return gson.toJson(document);
            }
            catch (Throwable e){
                e.printStackTrace();
                throw e;
            }
        });
    }
}

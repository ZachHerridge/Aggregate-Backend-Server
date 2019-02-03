package com.mhack.aggregate.server.api.post;

import com.arangodb.ArangoCollection;
import com.google.gson.Gson;
import com.mhack.aggregate.server.api.post.domain.Post;
import com.mhack.aggregate.server.database.arango.DBArango;
import com.mhack.aggregate.server.jwt.JwtUtil;
import spark.Spark;

import java.util.List;

public class PostAPI {

    private static Gson gson = new Gson();
    private static ArangoCollection posts = DBArango.getDb().collection("posts");

    private static List<Post> getBestPosts(String userId){
        return posts.db().query("FOR p IN posts\n" +
                "SORT p.time DESC\n" +
                "LIMIT 10\n" +
                "RETURN p", Post.class).asListRemaining();
    }

    public static void init() {
        Spark.put("/posts", (req, res) -> {
            String userId = JwtUtil.decodeToId(req.headers("jwt"));
            if (userId != null){
                Post post = gson.fromJson(req.body(), Post.class);
                post.setUserId(userId);
                posts.insertDocument(post);
                return "OK";
            }
            return "FAIL";
        });

        Spark.get("/posts/best", (req, res) -> {
            String userId = JwtUtil.decodeToId(req.headers("jwt"));
            if (userId != null){
                return gson.toJson(getBestPosts(userId));
            }
            return "FAIL";
        });
    }
}

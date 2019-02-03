package com.mhack.aggregate.server.api.post;

import com.arangodb.ArangoCollection;
import com.google.gson.Gson;
import com.mhack.aggregate.server.api.post.domain.Comment;
import com.mhack.aggregate.server.api.post.domain.Post;
import com.mhack.aggregate.server.database.arango.DBArango;
import com.mhack.aggregate.server.jwt.JwtUtil;
import spark.Spark;

import java.util.Collections;
import java.util.List;

public class PostAPI {

    private static Gson gson = new Gson();
    private static ArangoCollection posts = DBArango.getDb().collection("posts");
    private static ArangoCollection comments = DBArango.getDb().collection("comments");

    private static List<Post> getBestPosts() {
        return posts.db().query("FOR p IN posts\n" +
                "SORT p.time DESC\n" +
                "LIMIT 10\n" +
                "RETURN p", Post.class).asListRemaining();
    }

    private static List<Post> getBestPosts(String userId) {
        return posts.db().query("FOR p IN posts\n" +
                "SORT p.time DESC\n" +
                "LIMIT 10\n" +
                "return MERGE(p, {\"displayName\": DOCUMENT(\"users\", p.userId).displayName})", Post.class).asListRemaining();
    }

    public static void init() {
        Spark.get("/posts/:postId", (req, res) -> {
            return gson.toJson(comments.db().query("LET post = FIRST((\n" +
                    "FOR p IN posts\n" +
                    "    FILTER p._key == @postId\n" +
                    "    LIMIT 1\n" +
                    "    RETURN p\n" +
                    "))\n" +
                    "\n" +
                    "LET comments = (\n" +
                    "    FOR p IN comments\n" +
                    "    FILTER p.postId == @postId\n" +
                    "    SORT p.time DESC\n" +
                    "    return MERGE(p, {\"displayName\": DOCUMENT(\"users\", p.userId).displayName})\n" +
                    ")\n" +
                    "\n" +
                    "FILTER post != null\n" +
                    "\n" +
                    "return MERGE(post, {\"comments\": comments})", Collections.singletonMap("postId", req.params("postId")), Post.class).next());

        });

        Spark.put("/posts/:postId/comment", (req, res) -> {
            String userId = JwtUtil.decodeToId(req.headers("jwt"));
            if (userId != null) {
                Comment comment = gson.fromJson(req.body(), Comment.class);
                comment.setUserId(userId);
                comment.setPostId(req.params("postId"));
                comments.insertDocument(comment);
                return "OK";
            }
            return "FAIL";
        });

        Spark.put("/posts", (req, res) -> {
            String userId = JwtUtil.decodeToId(req.headers("jwt"));
            if (userId != null) {
                Post post = gson.fromJson(req.body(), Post.class);
                post.setUserId(userId);
                posts.insertDocument(post);
                return "OK";
            }
            return "FAIL";
        });

        Spark.get("/p/best", (req, res) -> {
            try{
                String userId = JwtUtil.decodeToId(req.headers("jwt"));
                if (userId != null) {
                    return gson.toJson(getBestPosts(userId));
                }
                return gson.toJson(getBestPosts());
            }
            catch (Throwable e){
                e.printStackTrace();
            }
            return "FAIL";
        });
    }
}

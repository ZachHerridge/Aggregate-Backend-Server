package com.mhack.aggregate.server.api.user;

import spark.Spark;

public class UserAPI {

    public static void init(){
        Spark.get("/user/:userid", (req, res) -> {
            String userId = req.params("userid");
            return "Hello user " + userId;
        });
    }
}

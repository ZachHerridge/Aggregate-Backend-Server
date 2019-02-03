package com.mhack.aggregate.server.api.user;

import spark.Spark;

public class UserAPI {

    public static void init(){
        Spark.get("/hello", (req, res) -> "Hello World");
    }
}

package com.mhack.aggregate.server.database.arango;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;

public class DBArango {

    private static ArangoDatabase db;

    public static void init(){
        ArangoDB arangoDB = new ArangoDB.Builder().host("116.203.79.45", 8529).user("root").password("uwrfacm123").build();
        db = arangoDB.db("Aggregate");
    }

    public static ArangoDatabase getDb() {
        return db;
    }
}

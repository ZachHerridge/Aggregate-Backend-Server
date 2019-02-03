package com.mhack.aggregate.server;

import com.mhack.aggregate.server.api.post.PostAPI;
import com.mhack.aggregate.server.api.user.UserAPI;
import com.mhack.aggregate.server.database.arango.DBArango;

public class Bootstrap {

    public static void main(String[] args) {
        DBArango.init();
        PostAPI.init();
        UserAPI.init();
    }
}

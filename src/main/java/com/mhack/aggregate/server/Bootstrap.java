package com.mhack.aggregate.server;

import com.mhack.aggregate.server.api.user.UserAPI;

public class Bootstrap {


    public static void main(String[] args) {
        UserAPI.init();
    }
}

package com.mhack.aggregate.server.api.user.domain;

public class User {

    private String _key;

    private String displayName;
    private String password;

    public String get_key() {
        return _key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }
}

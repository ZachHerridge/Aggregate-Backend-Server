package com.mhack.aggregate.server.api.user.domain;

import com.mhack.aggregate.server.api.user.domain.profile.Profile;

public class User {

    private String _key;
    private String displayName;
    private String password;
    private Profile profile;

    public User(String displayName, String password) {
        this.displayName = displayName;
        this.password = password;
    }

    public User() {
    }

    public String getKey() {
        return _key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

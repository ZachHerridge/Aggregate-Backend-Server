package com.mhack.aggregate.server.api.user.domain;

import com.mhack.aggregate.server.api.user.domain.profile.Profile;

public class User {

    private String _key;
    private String displayName;
    private String password;

    private Profile profile;

    public String getKey() {
        return _key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public User setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public Profile getProfile() {
        return profile;
    }
}

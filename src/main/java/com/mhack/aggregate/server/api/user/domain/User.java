package com.mhack.aggregate.server.api.user.domain;

import com.mhack.aggregate.server.api.user.domain.profile.Profile;

public class User {

    private String _key;
    private String displayName;
    private String password;
    private Profile profile;

    public User(String _key, String displayName, String password, Profile profile) {
        this._key = _key;
        this.displayName = displayName;
        this.password = password;
        this.profile = profile;
    }

    public String get_Key() {
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

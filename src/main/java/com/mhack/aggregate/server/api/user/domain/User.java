package com.mhack.aggregate.server.api.user.domain;

import com.mhack.aggregate.server.api.user.extra_variables.FarmEquipment;
import com.mhack.aggregate.server.api.user.extra_variables.FarmType;
import com.mhack.aggregate.server.api.user.extra_variables.ProfileLocation;

import java.util.HashSet;

public class User {

    private String _key;
    private String displayName;
    private String password;
    private String name;
    private ProfileLocation location;
    private HashSet<FarmEquipment> farmEquipment;
    private int farmSize;
    private HashSet<FarmType> farmTypes;

    public User(String _key, String displayName, String password, String name, ProfileLocation location,
                HashSet<FarmEquipment> farmEquipment, int farmSize, HashSet<FarmType> farmTypes) {
        this._key = _key;
        this.displayName = displayName;
        this.password = password;
        this.farmEquipment = farmEquipment;
        this.farmSize = farmSize;
        this.farmTypes = farmTypes;
    }

    public String get_key() {
        return _key;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileLocation getLocation() {
        return location;
    }

    public void setLocation(ProfileLocation location) {
        this.location = location;
    }

    public HashSet<FarmEquipment> getFarmEquipment() {
        return farmEquipment;
    }

    public void setFarmEquipment(HashSet<FarmEquipment> farmEquipment) {
        this.farmEquipment = farmEquipment;
    }

    public int getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(int farmSize) {
        this.farmSize = farmSize;
    }

    public HashSet<FarmType> getFarmTypes() {
        return farmTypes;
    }

    public void setFarmTypes(HashSet<FarmType> farmTypes) {
        this.farmTypes = farmTypes;
    }
}

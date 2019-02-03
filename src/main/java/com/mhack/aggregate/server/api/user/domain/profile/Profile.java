package com.mhack.aggregate.server.api.user.domain.profile;

import java.util.HashSet;

public class Profile {
    // Name of the user
    String name;

    // Location of their farm
    ProfileLocation location;

    // Size of their farm
    FarmSize farmSize;

    // A set of equipment they use
    // John Deer tractors, CAT tractors etc
    HashSet<FarmEquipment> equipment;

    // A set of farm types in which this profile is associated with
    // Dairy Farm, Cattle Farm etc etc
    HashSet<FarmType> farmTypes;

    public Profile(String name, ProfileLocation location, FarmSize farmSize, HashSet<FarmEquipment> equipment, HashSet<FarmType> farmTypes) {
        this.name = name;
        this.location = location;
        this.farmSize = farmSize;
        this.equipment = equipment;
        this.farmTypes = farmTypes;
    }

    public Profile(){
        name = "";
        location  = new ProfileLocation();
        farmSize = new FarmSize();
        equipment = new HashSet<>();
        farmTypes = new HashSet<>();
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

    public FarmSize getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(FarmSize farmSize) {
        this.farmSize = farmSize;
    }

    public HashSet<FarmEquipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashSet<FarmEquipment> equipment) {
        this.equipment = equipment;
    }

    public HashSet<FarmType> getFarmTypes() {
        return farmTypes;
    }

    public void setFarmTypes(HashSet<FarmType> farmTypes) {
        this.farmTypes = farmTypes;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", farmSize=" + farmSize +
                ", equipment=" + equipment +
                ", farmTypes=" + farmTypes +
                '}';
    }
}

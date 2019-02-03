package com.mhack.aggregate.server.api.user.extra_variables;

public class FarmEquipment {

    private String name;
    private int eqpId;

    public FarmEquipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setString(String name) {
        this.name = name;
    }
}

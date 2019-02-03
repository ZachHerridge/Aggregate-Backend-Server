package com.mhack.aggregate.server.api.user.extra_variables;

public class FarmEquipment {
    enum Equipment {
        Tractor,
        Plow,
        Harrow,
        FertilizerSpreader,
        Seeder,
        Baler,
        Harvester
    }

    private Equipment equipment;

    public FarmEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

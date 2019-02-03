package com.mhack.aggregate.server.api.user.domain.profile;

public class FarmEquipment{
    enum Equipment {
        Tractor,
        Plow,
        Harrow,
        FertilizerSpreader,
        Seeder,
        Baler,
        Harvester
    }

    Equipment equipment;

    public FarmEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public FarmEquipment() {
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}

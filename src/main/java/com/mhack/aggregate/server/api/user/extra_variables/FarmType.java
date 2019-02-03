package com.mhack.aggregate.server.api.user.extra_variables;

public class FarmType {

    enum Type {
        Dairy,
        Animal,
        Wheat,
        Corn,
        Cotton,
        Tobacco
    }

    private Type type;

    public FarmType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}

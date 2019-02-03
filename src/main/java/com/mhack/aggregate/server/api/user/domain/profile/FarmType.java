package com.mhack.aggregate.server.api.user.domain.profile;

class FarmType {
    // Need more types obviously, but this is good for a start
    enum Type {
        Dairy,
        Livestock,
        Wheat,
        Corn,
        Cotton,
        Tobacco
    }

    Type type;

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

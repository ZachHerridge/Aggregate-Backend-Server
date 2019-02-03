package com.mhack.aggregate.server.api.user.domain.profile;

public class FarmSize {

    int size;

    public FarmSize(){
        size = 0;
    }

    public FarmSize(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

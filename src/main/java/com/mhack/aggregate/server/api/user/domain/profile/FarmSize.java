package com.mhack.aggregate.server.api.user.domain.profile;

public class FarmSize {

    int size;
    int sizeBracket;

    public FarmSize(){
        size = 0;
        sizeBracket = 0;
    }

    public FarmSize(int size){
        this.size = size;
        setSizeBracket(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeBracket() {
        return sizeBracket;
    }

    private void setSizeBracket(int size) {
        if(size == 0) {
            sizeBracket = 0;
        } else if(size > 0 && size < 50) {
            sizeBracket = 1;
        } else if(size >= 50 && size < 150) {
            sizeBracket = 2;
        } else if(size >= 150 && size < 500) {
            sizeBracket = 3;
        } else if(size >=500 && size < 1000) {
            sizeBracket = 4;
        } else if(size >= 1000) {
            sizeBracket = 5;
        }
    }
}

package com.mhack.aggregate.server.api.user.domain.profile;

class ProfileLocation {

    enum Country {
        UnitedStates,
    }

    enum State {
        AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MI, MN
    }

    Country country;
    State state;
    LocationCoordinates coordinates;

    public ProfileLocation(){
        country = Country.UnitedStates;
        state = State.MN;
        coordinates = new LocationCoordinates(0, 0);
    }

    public ProfileLocation(Country country, State state, LocationCoordinates coordinates) {
        this.country = country;
        this.state = state;
        this.coordinates = coordinates;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocationCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LocationCoordinates coordinates) {
        this.coordinates = coordinates;
    }
}

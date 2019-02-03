package com.mhack.aggregate.server.api.user.domain.profile;

import java.awt.*;
import java.util.HashMap;

public class ProfileLocation {

    enum Country {
        USA
    }

    enum State {
        AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MI, MN
    }

    private Country country;
    private State state;
    private HashMap<State, Point> coordinatesMap = new HashMap<>();

    public ProfileLocation() {
        country = Country.USA;
        state = State.MN;
        initializeHashMap();
    }

    public ProfileLocation(Country country, State state, Point point) {
        this.country = country;
        this.state = state;
        initializeHashMap();
    }

    private void initializeHashMap() {
        coordinatesMap.put(State.AL, new Point(-86, 32));
        coordinatesMap.put(State.AK, new Point(-134, 58));
        coordinatesMap.put(State.AZ, new Point(-112, 33));
        coordinatesMap.put(State.AR, new Point(-92, 35));
        coordinatesMap.put(State.CA, new Point(-92, 39));
        coordinatesMap.put(State.CO, new Point(-105, 40));
        coordinatesMap.put(State.CT, new Point(-73, 42));
        coordinatesMap.put(State.DE, new Point(-76, 39));
        coordinatesMap.put(State.FL, new Point(-84, 30));
        coordinatesMap.put(State.GA, new Point(-84, 34));
        coordinatesMap.put(State.HI, new Point(-158, 21));
        coordinatesMap.put(State.ID, new Point(-116, 44));
        coordinatesMap.put(State.IL, new Point(-86, 40));
        coordinatesMap.put(State.IN, new Point(-86, 40));
        coordinatesMap.put(State.IA, new Point(-94, 42));
        coordinatesMap.put(State.KS, new Point(-96, 39));
        coordinatesMap.put(State.KY, new Point(-85, 38));
        coordinatesMap.put(State.LA, new Point(-91, 30));
        coordinatesMap.put(State.ME, new Point(-70, 44));
        coordinatesMap.put(State.MD, new Point(-77, 39));
        coordinatesMap.put(State.MI, new Point(-85, 43));
        coordinatesMap.put(State.MN, new Point(-93, 45));
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public HashMap<State, Point> getCoordinatesMap() {
        return coordinatesMap;
    }
}

package com.mhack.aggregate.server.api.user.extra_variables;

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
    private HashMap<State, Point> coordinatesMap;

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
        coordinatesMap.put(State.AL, new Point(32, -86));
        coordinatesMap.put(State.AK , new Point(58, -134));
        coordinatesMap.put(State.AZ , new Point(33, -112));
        coordinatesMap.put(State.AR , new Point(35, -92));
        coordinatesMap.put(State.CA , new Point(39, -92));
        coordinatesMap.put(State.CO , new Point(40, -105));
        coordinatesMap.put(State.CT , new Point(42, -73));
        coordinatesMap.put(State.DE , new Point(39, -76));
        coordinatesMap.put(State.FL , new Point(30, -84));
        coordinatesMap.put(State.GA , new Point(34, -84));
        coordinatesMap.put(State.HI , new Point(21, -158));
        coordinatesMap.put(State.ID , new Point(44, -116));
        coordinatesMap.put(State.IL , new Point(40, -86));
        coordinatesMap.put(State.IN , new Point(40, -86));
        coordinatesMap.put(State.IA , new Point(42, -94));
        coordinatesMap.put(State.KS , new Point(39, -96));
        coordinatesMap.put(State.KY , new Point(38, -85));
        coordinatesMap.put(State.LA , new Point(30, -91));
        coordinatesMap.put(State.ME , new Point(44, -70));
        coordinatesMap.put(State.MD , new Point(39, -77));
        coordinatesMap.put(State.MI , new Point(43, -85));
        coordinatesMap.put(State.MN , new Point(45, -93));
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

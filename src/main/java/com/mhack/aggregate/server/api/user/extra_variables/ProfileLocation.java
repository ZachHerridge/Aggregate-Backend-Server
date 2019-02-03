package com.mhack.aggregate.server.api.user.extra_variables;

import java.awt.*;

public class ProfileLocation {

    enum Country {
        USA
    }

    enum State {
        AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MI, MN
    }

    private Country country;
    private State state;
    private Point point;

    public ProfileLocation() {
        country = Country.USA;
        state = State.MN;
        point = new Point(0,0);
    }

    public ProfileLocation(Country country, State state, Point point) {
        this.country = country;
        this.state = state;
        this.point = point;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

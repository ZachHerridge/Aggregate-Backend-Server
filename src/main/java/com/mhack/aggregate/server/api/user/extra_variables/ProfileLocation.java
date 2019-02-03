package com.mhack.aggregate.server.api.user.extra_variables;

import java.awt.*;

public class ProfileLocation {

    enum Country {
        USA
    }

    private Country country;
    private Point point;

    public ProfileLocation() {
        country = Country.USA;
        point = new Point(0,0);
    }

    public ProfileLocation(Country country, Point point) {
        this.country = country;
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

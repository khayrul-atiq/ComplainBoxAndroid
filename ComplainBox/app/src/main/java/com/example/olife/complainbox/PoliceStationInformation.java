package com.example.olife.complainbox;

/**
 * Created by olife on 4/5/2018.
 */

public class PoliceStationInformation implements Information{

    private String name, location;

    public PoliceStationInformation(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

package com.example.olife.complainbox;

/**
 * Created by olife on 4/5/2018.
 */

public class FireStationInfromation {
    private String name, location;

    public FireStationInfromation(String name, String location) {
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

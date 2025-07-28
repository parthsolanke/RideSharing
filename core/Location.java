package core;

import java.util.*;

public class Location {
    private String name;
    private List<String> nearByLocations;
    private List<String> farByLocations;

    public Location(String name, List<String> nearByLocations, List<String> farByLocation) {
        this.name = name;
        this.nearByLocations = nearByLocations;
        this.farByLocations = farByLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNearByLocations() {
        return nearByLocations;
    }

    public void setNearByLocations(List<String> nearByLocations) {
        this.nearByLocations = nearByLocations;
    }

    public List<String> getFarByLocations() {
        return farByLocations;
    }

    public void setFarByLocations(List<String> farByLocations) {
        this.farByLocations = farByLocations;
    }
}
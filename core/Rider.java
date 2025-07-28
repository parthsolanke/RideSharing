package core;

import java.util.*;

public class Rider extends User {
    private static int idCounter;
    private int id;
    private List<Driver> rideHistory = new ArrayList<>();

    public Rider(String name) {
        super(name, Role.RIDER);
        this.id = +idCounter;
    }

    public void updateRideHistory(Driver driver) {
        rideHistory.add(driver);
    }

    public int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Driver> getRideHistory() {
        return rideHistory;
    }

    public int getTotalRides() {
        return rideHistory.size();
    }

    public void setRideHistory(List<Driver> rideHistory) {
        this.rideHistory = rideHistory;
    }

}
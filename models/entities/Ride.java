package models.entities;

import models.enums.Status;

public class Ride {
    private final int id;
    private static int idCounter = 0;
    private Status status;
    private final Rider rider;
    private final Driver driver;
    private final Location source;
    private final Location destination;
    private double fare;

    public Ride(Status status, Rider rider, Driver driver, Location source, Location destination) {
        this.source = source;
        this.destination = destination;
        this.id = ++idCounter;
        this.status = status;
        this.rider = rider;
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Location getDestination() {
        return destination;
    }

    public Location getSource() {
        return source;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "status=" + status +
                ", rider=" + rider.getName() +
                ", driver=" + driver.getName() +
                '}';
    }
}

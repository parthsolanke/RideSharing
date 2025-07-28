package core;

public class Driver extends User {
    private static int idCounter;
    private int id;
    private final Vehicle vehicle;
    private double avgRating;
    private int totalRatings; // NEW
    private boolean isEngaged;

    public Driver(String name, Vehicle vehicle) {
        super(name, Role.DRIVER);
        this.id = ++idCounter;
        this.vehicle = vehicle;
        this.avgRating = 0;
        this.totalRatings = 0;
        this.isEngaged = false;
    }

    public void updateRating(double newRating) {
        this.avgRating = (this.avgRating * this.totalRatings + newRating) / (++this.totalRatings);
    }

    public int getTotalRatings() {
        return totalRatings;
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

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public boolean isEngaged() {
        return !isEngaged;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setEngaged(boolean engaged) {
        isEngaged = engaged;
    }
}
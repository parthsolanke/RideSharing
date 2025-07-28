package core;

public class RideRequest {
    private Rider rider;
    private Location destination;
    private Vehicle vehicle;
    private Double rating;

    public RideRequest(Rider rider, Location destination, Vehicle vehicle, Double rating) {
        this.rider = rider;
        this.destination = destination;
        this.vehicle = vehicle;
        this.rating = rating;
    }

    public Rider getRider() {
        return rider;
    }

    public Location getDestination() {
        return destination;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Double getRating() {
        return rating;
    }

    public boolean isCancelled() {
        return rating == null;
    }
}

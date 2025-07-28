package core;

import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private Map<Driver, Location> driverToLocation;
    private Map<Rider, Location> riderToCurrentLocation;
    private final List<Ride> rideHistory = new ArrayList<>();
    private final FareCalculator fareCalculator = new FareCalculator();

    public Manager(Map<Driver, Location> driverToLocation, Map<Rider, Location> riderToCurrentLocation) {
        this.driverToLocation = driverToLocation;
        this.riderToCurrentLocation = riderToCurrentLocation;
    }

    private List<Driver> matchNearByDrivers(Location destination, Vehicle preferredVehicle) {
        return driverToLocation.entrySet().stream()
                .filter(entry -> entry.getKey().isEngaged())
                .filter(entry -> entry.getKey().getVehicle().equals(preferredVehicle))
                .filter(entry -> destination.getNearByLocations().contains(entry.getValue().getName()))
                .map(Map.Entry::getKey)
                .toList();
    }

    private List<Driver> matchFarByDrivers(Location destination, Vehicle preferredVehicle) {
        return driverToLocation.entrySet().stream()
                .filter(entry -> entry.getKey().isEngaged())
                .filter(entry -> entry.getKey().getVehicle().equals(preferredVehicle))
                .filter(entry -> destination.getFarByLocations().contains(entry.getValue().getName()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public Ride processRideRequest(Rider rider, Location destination, Vehicle preferredVehicle) {
        Location source = riderToCurrentLocation.get(rider);
        System.out.println("\nRide request from " + rider.getName() +
                " to " + destination.getName() +
                " (Prefers: " + preferredVehicle + ")");

        List<Driver> availableDrivers = matchNearByDrivers(source, preferredVehicle);

        if (availableDrivers.isEmpty()) {
            System.out.println("No nearby drivers. Searching in distant locations...");
            availableDrivers = matchFarByDrivers(source, preferredVehicle);
        }

        if (availableDrivers.isEmpty()) {
            System.out.println("No available drivers for " + rider.getName() + " at this time.");
            return null;
        }

        Driver assignedDriver = availableDrivers.get(new Random().nextInt(availableDrivers.size()));
        assignedDriver.setEngaged(true);

        Ride ride = new Ride(Status.REQUESTED, rider, assignedDriver, source, destination);
        ride.setStatus(Status.ONGOING);
        rideHistory.add(ride);

        System.out.println("Driver " + assignedDriver.getName() + " assigned to " +
                rider.getName() + " (Ride ID: " + ride.getId() + ")");
        return ride;
    }


    public void completeRide(Ride ride, Location destination, double rating) {
        double fare = fareCalculator.calculateFare(ride);
        Rider rider = ride.getRider();
        Driver driver = ride.getDriver();

        if (!rider.deductFromWallet(fare)) {
            ride.setStatus(Status.CANCELLED);
            driver.setEngaged(false);

            System.out.println("\nRide could not be completed due to insufficient balance.");
            System.out.println("Ride cancelled: " + rider.getName() + " → " + destination.getName() +
                    " | Required fare: ₹" + fare + ", Wallet balance: ₹" + rider.getWalletBalance());
            return;
        }

        driver.addToWallet(fare);
        ride.setStatus(Status.COMPLETED);
        driver.setEngaged(false);

        driverToLocation.put(driver, destination);
        riderToCurrentLocation.put(rider, destination);

        driver.updateRating(rating);
        rider.updateRideHistory(driver);

        System.out.println("\nRide completed: " + rider.getName() +
                " with " + driver.getName() +
                " → Arrived at " + destination.getName() +
                " | Fare: ₹" + fare +
                " | Rating: " + rating +
                " | New Avg Rating: " + String.format("%.2f", driver.getAvgRating()));

        System.out.println(rider.getName() + " new wallet balance: ₹" + rider.getWalletBalance());
        System.out.println(driver.getName() + " new wallet balance: ₹" + driver.getWalletBalance());
    }


    public void cancelRide(Ride ride) {
        ride.setStatus(Status.CANCELLED);
        ride.getDriver().setEngaged(false);

        System.out.println("\nRide cancelled: " + ride);
    }

    public List<Driver> getTopRatedDrivers() {
        return getAllDrivers().stream()
                .sorted(Comparator.comparingDouble(Driver::getAvgRating)
                        .reversed())
                .toList();
    }

    public int getTotalRides() {
        return rideHistory.size();
    }

    public Map<Vehicle, Long> getRideCountPerVehicleType() {
        return getRideHistory().stream()
                .collect(Collectors.groupingBy(
                        ride -> ride.getDriver().getVehicle(),
                        Collectors.counting()
                ));
    }

    public List<Rider> getMostActiveRiders() {
        return getAllRiders().stream()
                .sorted(Comparator.comparingInt(Rider::getTotalRides)
                        .reversed())
                .toList();
    }

    public List<Rider> getAllRiders() {
        return riderToCurrentLocation.keySet().stream().toList();
    }

    public List<Driver> getAllDrivers() {
        return driverToLocation.keySet().stream().toList();
    }

    public Map<Driver, Location> getDriverToLocation() {
        return driverToLocation;
    }

    public void setDriverToLocation(Map<Driver, Location> driverToLocation) {
        this.driverToLocation = driverToLocation;
    }

    public Map<Rider, Location> getRiderToCurrentLocation() {
        return riderToCurrentLocation;
    }

    public void setRiderToCurrentLocation(Map<Rider, Location> riderToCurrentLocation) {
        this.riderToCurrentLocation = riderToCurrentLocation;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }
}
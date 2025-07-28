package core;

import java.util.Map;

public class ReportGenerator {

    public static void printAnalyticsSummary(Manager manager) {
        System.out.println("\n---- Analytics Summary ----");

        printTotalCompletedRides(manager);
        printTopRatedDrivers(manager, 3);
        printMostActiveRiders(manager, 3);
        printRideCountPerVehicleType(manager);
    }

    public static void printFinalSummary(Manager manager) {
        System.out.println("\n---- Final Ride History ----");
        for (Ride ride : manager.getRideHistory()) {
            System.out.println("Ride: " + ride.getRider().getName() + " with " + ride.getDriver().getName()
                    + " | Vehicle: " + ride.getDriver().getVehicle()
                    + " | Status: " + ride.getStatus());
        }

        System.out.println("\n---- Updated Rider Locations ----");
        for (Map.Entry<Rider, Location> entry : manager.getRiderToCurrentLocation().entrySet()) {
            System.out.println("Rider " + entry.getKey().getName() + " is now at " + entry.getValue().getName());
        }

        System.out.println("\n---- Updated Driver Locations ----");
        for (Map.Entry<Driver, Location> entry : manager.getDriverToLocation().entrySet()) {
            System.out.println("Driver " + entry.getKey().getName() + " is now at " + entry.getValue().getName());
        }
    }


    public static void printTotalCompletedRides(Manager manager) {
        System.out.println("Total Completed Rides: " + manager.getTotalRides());
    }

    public static void printTopRatedDrivers(Manager manager, int limit) {
        System.out.println("\nTop Rated Drivers:");
        manager.getTopRatedDrivers().stream().limit(limit).forEach(driver ->
                System.out.println("Driver: " + driver.getName() +
                        " | Rating: " + String.format("%.2f", driver.getAvgRating()))
        );
    }

    public static void printMostActiveRiders(Manager manager, int limit) {
        System.out.println("\nMost Active Riders:");
        manager.getMostActiveRiders().stream().limit(limit).forEach(rider ->
                System.out.println("Rider: " + rider.getName() +
                        " | Total Rides: " + rider.getTotalRides())
        );
    }

    public static void printRideCountPerVehicleType(Manager manager) {
        System.out.println("\nRide Count per Vehicle Type:");
        manager.getRideCountPerVehicleType().forEach((vehicle, count) ->
                System.out.println(vehicle + ": " + count + " rides")
        );
    }
}

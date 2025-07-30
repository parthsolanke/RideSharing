package services;

import models.entities.Driver;
import models.entities.Location;
import models.entities.Ride;
import models.entities.Rider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class FileReportGenerator extends ReportGenerator {
    private final PrintWriter writer;

    public FileReportGenerator(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        this.writer = new PrintWriter(new BufferedWriter(fw));
    }

    public void writeAnalyticsSummary(Manager manager) {
        writer.println("\n---- Analytics Summary ----");

        writer.println("Total Completed Rides: " + manager.getTotalRides());

        writer.println("\nTop Rated Drivers:");
        manager.getTopRatedDrivers().stream().limit(3).forEach(driver ->
                writer.println("Driver: " + driver.getName() +
                        " | Rating: " + String.format("%.2f", driver.getAvgRating()))
        );

        writer.println("\nMost Active Riders:");
        manager.getMostActiveRiders().stream().limit(3).forEach(rider ->
                writer.println("Rider: " + rider.getName() +
                        " | Total Rides: " + rider.getTotalRides())
        );

        writer.println("\nRide Count per Vehicle Type:");
        manager.getRideCountPerVehicleType().forEach((vehicle, count) ->
                writer.println(vehicle + ": " + count + " rides")
        );

        writer.flush();
    }

    public void writeFinalSummary(Manager manager) {
        writer.println("\n---- Final Ride History ----");
        for (Ride ride : manager.getRideHistory()) {
            writer.println("Ride: " + ride.getRider().getName() + " with " + ride.getDriver().getName()
                    + " | Vehicle: " + ride.getDriver().getVehicle()
                    + " | Status: " + ride.getStatus());
        }

        writer.println("\n---- Updated Rider Locations ----");
        for (Map.Entry<Rider, Location> entry : manager.getRiderToCurrentLocation().entrySet()) {
            writer.println("Rider " + entry.getKey().getName() + " is now at " + entry.getValue().getName());
        }

        writer.println("\n---- Updated Driver Locations ----");
        for (Map.Entry<Driver, Location> entry : manager.getDriverToLocation().entrySet()) {
            writer.println("Driver " + entry.getKey().getName() + " is now at " + entry.getValue().getName());
        }

        writer.flush();
    }

    public void close() {
        writer.close();
    }
}
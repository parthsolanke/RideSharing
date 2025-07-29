import engine.RideRequestGenerator;
import engine.RideRequestProcessor;
import engine.config.DataLoader;
import models.entities.Driver;
import models.entities.Location;
import models.entities.Rider;
import services.Manager;
import services.ReportGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = DataLoader.loadLocations();
        Map<Driver, Location> drivers = DataLoader.loadDrivers(locations);
        Map<Rider, Location> riders = DataLoader.loadRiders(locations);

        Manager manager = new Manager(drivers, riders);
        List<Rider> riderList = new ArrayList<>(riders.keySet());

        int numberOfRequests = 50;
        RideRequestGenerator generator = new RideRequestGenerator(riderList, locations, manager);
        RideRequestProcessor processor = new RideRequestProcessor(manager);

        for (int i = 0; i < numberOfRequests; i++) {
            processor.process(generator.generate());
        }

        ReportGenerator.printAnalyticsSummary(manager);
        ReportGenerator.printFinalSummary(manager);
    }
}

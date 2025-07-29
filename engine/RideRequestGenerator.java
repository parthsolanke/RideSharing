package engine;

import models.enums.Vehicle;
import models.entities.Location;
import models.entities.Rider;
import services.Manager;
import utils.RideRequest;

import java.util.List;
import java.util.Random;

public class RideRequestGenerator {
    private final List<Rider> riders;
    private final List<Location> allLocations;
    private final Manager manager;
    private final Random random = new Random();

    public RideRequestGenerator(List<Rider> riders, List<Location> allLocations, Manager manager) {
        this.riders = riders;
        this.allLocations = allLocations;
        this.manager = manager;
    }

    public RideRequest generate() {
        Rider rider = riders.get(random.nextInt(riders.size()));
        Location source = manager.getRiderToCurrentLocation().get(rider);
        Location destination;

        do {
            destination = allLocations.get(random.nextInt(allLocations.size()));
        } while (destination.equals(source));

        Vehicle vehicle = Vehicle.values()[random.nextInt(Vehicle.values().length)];

        boolean cancel = random.nextDouble() < 0.3;
        Double rating = cancel ? null : Math.round((3.5 + 1.5 * random.nextDouble()) * 10.0) / 10.0;

        return new RideRequest(rider, destination, vehicle, rating);
    }
}

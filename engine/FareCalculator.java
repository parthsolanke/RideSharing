package engine;

import models.entities.Location;
import models.entities.Ride;
import models.enums.Vehicle;

public class FareCalculator {

    public final static double DISTANCE_SURCHARGE_FOR_FAR = 50.0;

    public double calculateFare(Ride ride) {
        Vehicle vehicle = ride.getDriver().getVehicle();
        Location source = ride.getSource();
        Location destination = ride.getDestination();

        double baseFare = switch (vehicle) {
            case BIKE -> 75.0;
            case AUTO -> 100.0;
            case CAR -> 150.0;
        };

        double surcharge = 0.0;
        if (destination.getFarByLocations().contains(source.getName())) {
            surcharge = DISTANCE_SURCHARGE_FOR_FAR;
        }

        return baseFare + surcharge;
    }
}

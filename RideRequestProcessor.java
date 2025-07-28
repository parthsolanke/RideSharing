import core.*;

public class RideRequestProcessor {

    private final Manager manager;

    public RideRequestProcessor(Manager manager) {
        this.manager = manager;
    }

    public void process(RideRequest request) {
        Rider rider = request.getRider();
        Ride ride = manager.processRideRequest(rider, request.getDestination(), request.getVehicle());

        if (ride != null) {
            if (request.isCancelled()) {
                manager.cancelRide(ride);
            } else {
                manager.completeRide(ride, request.getDestination(), request.getRating());
            }
        } else {
            System.out.println("Ride request failed for " + rider.getName() + "\n");
        }

        System.out.println("---------------------------------------------------");
    }
}
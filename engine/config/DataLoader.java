package engine.config;

import models.enums.Vehicle;
import models.entities.Driver;
import models.entities.Location;
import models.entities.Rider;

import java.util.*;

public class DataLoader {

    public static List<Location> loadLocations() {
        Location baner = new Location("baner", List.of("balewadi", "aundh"), List.of("kothrud", "warje", "shivajinagar"));
        Location kothrud = new Location("kothrud", List.of("warje", "karvenagar"), List.of("balewadi", "baner", "aundh"));
        Location karvenagar = new Location("karvenagar", List.of("kothrud", "warje"), List.of("aundh", "balewadi", "baner"));
        Location balewadi = new Location("balewadi", List.of("baner", "aundh"), List.of("kothrud", "warje", "karvenagar"));
        Location aundh = new Location("aundh", List.of("balewadi", "baner"), List.of("kothrud", "warje", "karvenagar"));
        Location warje = new Location("warje", List.of("kothrud", "karvenagar"), List.of("balewadi", "baner", "aundh"));
        Location shivajinagar = new Location("shivajinagar", List.of("baner", "aundh"), List.of("kothrud", "karvenagar"));
        Location hinjewadi = new Location("hinjewadi", List.of("balewadi", "baner"), List.of("karvenagar", "warje"));

        return List.of(baner, kothrud, karvenagar, balewadi, aundh, warje, shivajinagar, hinjewadi);
    }

    public static Map<Driver, Location> loadDrivers(List<Location> locations) {
        Map<Driver, Location> map = new HashMap<>();

        // Create driver and set wallet
        Driver d1 = new Driver("Max", Vehicle.CAR); d1.setWalletBalance(0);
        Driver d2 = new Driver("Elon", Vehicle.BIKE); d2.setWalletBalance(0);
        Driver d3 = new Driver("Mark", Vehicle.AUTO); d3.setWalletBalance(0);
        Driver d4 = new Driver("Alice", Vehicle.CAR); d4.setWalletBalance(0);
        Driver d5 = new Driver("Bob", Vehicle.BIKE); d5.setWalletBalance(0);
        Driver d6 = new Driver("Clara", Vehicle.AUTO); d6.setWalletBalance(0);
        Driver d7 = new Driver("David", Vehicle.BIKE); d7.setWalletBalance(0);
        Driver d8 = new Driver("Sophia", Vehicle.CAR); d8.setWalletBalance(0);
        Driver d9 = new Driver("Liam", Vehicle.AUTO); d9.setWalletBalance(0);
        Driver d10 = new Driver("Nora", Vehicle.CAR); d10.setWalletBalance(0);
        Driver d11 = new Driver("Ethan", Vehicle.CAR); d11.setWalletBalance(0);
        Driver d12 = new Driver("Emma", Vehicle.BIKE); d12.setWalletBalance(0);
        Driver d13 = new Driver("Olivia", Vehicle.AUTO); d13.setWalletBalance(0);
        Driver d14 = new Driver("Aarav", Vehicle.BIKE); d14.setWalletBalance(0);
        Driver d15 = new Driver("Zara", Vehicle.CAR); d15.setWalletBalance(0);
        Driver d16 = new Driver("Jay", Vehicle.AUTO); d16.setWalletBalance(0);

        map.put(d1, locations.get(0));
        map.put(d2, locations.get(1));
        map.put(d3, locations.get(2));
        map.put(d4, locations.get(3));
        map.put(d5, locations.get(4));
        map.put(d6, locations.get(5));
        map.put(d7, locations.get(0));
        map.put(d8, locations.get(1));
        map.put(d9, locations.get(2));
        map.put(d10, locations.get(3));
        map.put(d11, locations.get(6));
        map.put(d12, locations.get(6));
        map.put(d13, locations.get(7));
        map.put(d14, locations.get(7));
        map.put(d15, locations.get(0));
        map.put(d16, locations.get(1));

        return map;
    }

    public static Map<Rider, Location> loadRiders(List<Location> locations) {
        Map<Rider, Location> map = new HashMap<>();

        // Create rider and set wallet
        Rider r1 = new Rider("Parth"); r1.setWalletBalance(500);
        Rider r2 = new Rider("John"); r2.setWalletBalance(300);
        Rider r3 = new Rider("Bob"); r3.setWalletBalance(0);           // Will fail to complete a ride
        Rider r4 = new Rider("Lily"); r4.setWalletBalance(700);
        Rider r5 = new Rider("Maya"); r5.setWalletBalance(400);
        Rider r6 = new Rider("Alex"); r6.setWalletBalance(200);
        Rider r7 = new Rider("Isha"); r7.setWalletBalance(600);
        Rider r8 = new Rider("Kabir"); r8.setWalletBalance(100);
        Rider r9 = new Rider("Reeva"); r9.setWalletBalance(450);
        Rider r10 = new Rider("Aryan"); r10.setWalletBalance(250);
        Rider r11 = new Rider("Saanvi"); r11.setWalletBalance(500);
        Rider r12 = new Rider("Nikhil"); r12.setWalletBalance(350);
        Rider r13 = new Rider("Tara"); r13.setWalletBalance(150);
        Rider r14 = new Rider("Yash"); r14.setWalletBalance(800);

        map.put(r1, locations.get(0));
        map.put(r2, locations.get(3));
        map.put(r3, locations.get(2));
        map.put(r4, locations.get(1));
        map.put(r5, locations.get(4));
        map.put(r6, locations.get(5));
        map.put(r7, locations.get(6));
        map.put(r8, locations.get(7));
        map.put(r9, locations.get(1));
        map.put(r10, locations.get(3));
        map.put(r11, locations.get(0));
        map.put(r12, locations.get(2));
        map.put(r13, locations.get(6));
        map.put(r14, locations.get(7));

        return map;
    }
}

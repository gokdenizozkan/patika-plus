package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.blup.Location;

import java.util.ArrayList;

public class LocationManager {
    private static Location playersLocation;
    private static ArrayList<Location> locations = new ArrayList<>();
    private static Location ground = new Location();

    protected static void addLocation(Location location) {
        locations.add(location);
    }

    protected static void updatePlayersLocation() {
        playersLocation = GameManager.getPlayer().getCurrentLocation();
    }

    protected static Being getEnemy() throws Exception {
        return playersLocation.getBeingExcept(GameManager.getPlayer());
    }

    protected static ArrayList<Location> getAccessibleLocationsFrom(Location here) {
        ArrayList<Location> accessibleLocations = new ArrayList<>();
        for (Location l : locations) {
            if (l.isLocked()) {
                continue;
            }
            if (l.getAccessibleFrom().equals(here)) {
                accessibleLocations.add(l);
            }
        }
        return accessibleLocations;
    }

    public static Location getLocation(Location l) {
        return locations.get(locations.indexOf(l));
    }

    public static Location getGround() {
        return ground;
    }
}

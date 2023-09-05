package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.blup.Location;
import patikaplus.week4.nighter.prod.Enemy;
import patikaplus.week4.nighter.prod.Player;

import java.util.ArrayList;

public class LocationManager {
    static Location playersLocation;
    static ArrayList<Location> locations;
    public static void locatePlayer() {
    }

    protected static void addLocation(Location location) {
        locations.add(location);
    }

    protected static void updatePlayersLocation() {
        playersLocation = GameManager.getPlayer().getCurrentLocation();
    }
    protected static Being getEnemy() throws Exception {
        return playersLocation.getBeingExcept(GameManager.getPlayer());
    }
}

package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.arran.Id;
import patikaplus.week4.nighter.arran.LocationProperty;
import patikaplus.week4.nighter.arran.Signal;
import patikaplus.week4.nighter.manag.LocationManager;

import java.util.ArrayList;

public class Location {
    final Id id = new Id(Id.Type.LOCATION);
    private boolean locked;
    private Location accessibleFrom;

    String name;
    ArrayList<LocationProperty> properties = new ArrayList<>(1);
    ArrayList<Being> here = new ArrayList<>(2);

    Signal locationAdded = new Signal(this, Signal.Type.LOCATIONADDED);

    public Location() {
        locationAdded.emit();
    }

    public Location(Location accessibleFrom) {
        this.accessibleFrom = accessibleFrom;
    }

    public Location(Location accessibleFrom, LocationProperty... properties) {
        this.accessibleFrom = accessibleFrom;
        for (LocationProperty p : properties) {
            this.properties.add(p);
        }
    }



    public void add(Being being) {
        here.add(being);
    }

    public void remove(Being being) {
        here.remove(being);
    }

    public boolean isHere(Being being) {
        return here.contains(being);
    }

    public ArrayList<Being> getListOfHere() {
        return here;
    }

    public Being getBeingExcept(Being being) throws Exception {
        if (here.size() < 3) {
            for (Being b : here) {
                if (b.equals(being)) continue;
                return b;
            }
        }
        else {
            throw new Exception("!!! More than two Beings in here !!!\n!!! Cannot proceed !!!");
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isLocked() {
        return locked;
    }

    public Location getAccessibleFrom() {
        return accessibleFrom;
    }

    public static class Builtin {
        Location cave = new Location(LocationManager.getGround(), LocationProperty.COMBAT);
        Location woods = new Location(LocationManager.getGround(), LocationProperty.COMBAT);
        Location river = new Location(LocationManager.getGround(), LocationProperty.COMBAT);
        Location safehouse = new Location(LocationManager.getGround(), LocationProperty.REGEN);
    }
}
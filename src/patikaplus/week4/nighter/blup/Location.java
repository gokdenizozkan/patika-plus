package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.arran.Id;
import patikaplus.week4.nighter.arran.LocationProperty;
import patikaplus.week4.nighter.arran.Signal;
import patikaplus.week4.nighter.manag.GameManager;
import patikaplus.week4.nighter.prod.Enemy;

import java.util.ArrayList;

public abstract class Location {
    final Id id = Id.LOCATION;

    String name;
    ArrayList<LocationProperty> properties;
    ArrayList<Being> here = new ArrayList<>();

    Signal locationAdded = Signal.LOCATIONADDED;

    public Location() {
        locationAdded.emit();
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
}
package patikaplus.week4.nighter.arran;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.blup.Item;
import patikaplus.week4.nighter.blup.Location;
import patikaplus.week4.nighter.manag.SignalManager;

public enum Signal {
    DIED (SignalGroup.BEING), ATTACKED (SignalGroup.BEING), FLED (SignalGroup.BEING),
    LOCATIONADDED (SignalGroup.LOCATION);

    private SignalGroup group;
    private Being emitterBeing;
    private Item emitterItem;
    private Location emitterLocation;

    Signal(SignalGroup group) {
        this.group = group;
    }

    public void emit() {
        SignalManager.receiveSignal(this);
    }

    public void emit(int value) {
        SignalManager.receiveSignal(this, value);
    }

    public SignalGroup getGroup() {
        return group;
    }

    public Being getEmitterBeing() {
        return emitterBeing;
    }

    public Location getEmitterLocation() {
        return emitterLocation;
    }

    public Item getEmitterItem() {
        return emitterItem;
    }


}

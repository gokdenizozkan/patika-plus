package patikaplus.week4.nighter.arran;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.blup.Item;
import patikaplus.week4.nighter.blup.Location;
import patikaplus.week4.nighter.blup.Scene;
import patikaplus.week4.nighter.manag.SignalManager;

public class Signal {
    private final Type type;
    private final Object emitter;
    private final Being emitterBeing;
    private final Item emitterItem;
    private final Location emitterLocation;
    private final Scene emitterScene;
    
    public Signal(Object emitter, Type type) {
        this.type = type;
        this.emitter = emitter;

        this.emitterBeing = null;
        this.emitterItem = null;
        this.emitterLocation = null;
        this.emitterScene = null;
    }

    public Signal(Being emitter, Type type) {
        this.type = type;
        this.emitterBeing = emitter;

        this.emitter = null;
        this.emitterItem = null;
        this.emitterLocation = null;
        this.emitterScene = null;
    }

    public Signal(Item emitter, Type type) {
        this.type = type;
        this.emitterItem = emitter;

        this.emitter = null;
        this.emitterBeing = null;
        this.emitterLocation = null;
        this.emitterScene = null;
    }

    public Signal(Location emitter, Type type) {
        this.type = type;
        this.emitterLocation = emitter;

        this.emitter = null;
        this.emitterBeing = null;
        this.emitterItem = null;
        this.emitterScene = null;
    }
    
    public Signal(Scene emitter, Type type) {
        this.type = type;
        this.emitterScene = emitter;

        this.emitter = null;
        this.emitterBeing = null;
        this.emitterItem = null;
        this.emitterLocation = null;
    }


    public void emit() {
        SignalManager.receiveSignal(this);
    }

    public void emit(int value) {
        SignalManager.receiveSignal(this, value);
    }
    
    public void emit(Object... sths) {
    	SignalManager.receiveSignal(this, sths);
    }

    public Object getEmitter() {
        return emitter;
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

    public Type getType() {
        return type;
    }

    public enum Type {
        DIED(Group.BEING), ATTACKED(Group.BEING), DEFENDED(Group.BEING), FLED(Group.BEING), LOOTED(Group.BEING),
        LOCATIONADDED(Group.LOCATION),
        CUT(Group.SCENE), CHARACTERCREATED(Group.SCENE);

        private final Group group;

        Type(Group group) {
            this.group = group;
        }

        public Group getGroup() {
            return group;
        }

        public enum Group {
            BEING, ITEM, LOCATION, SCENE;
        }
    }
}

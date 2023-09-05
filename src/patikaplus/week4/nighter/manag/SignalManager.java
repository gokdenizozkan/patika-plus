package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.arran.Signal;

public class SignalManager {
    public static void receiveSignal(Signal signal, Object... target) {
        switch (signal.getGroup()) {
            case BEING -> handleBeing(signal, target);
            case ITEM -> handleItem(signal, target);
            case LOCATION -> handleLocation(signal, target);
        }
    }

    private static void channelSignal() {
        //
    }

    private static void handleBeing(Signal signal, Object... target) {
        switch (signal) {
            case DIED -> {
                if (signal.getEmitterBeing().equals(GameManager.getPlayer())) { // If player died
                    GameManager.end();
                }
                else { // If someone else (enemy) died
                    // end combat
                }
            }
            case ATTACKED -> signal.getEmitterBeing();
            case FLED -> System.out.println("Just signalled FLED, WIP"); // TODO
        }
    }

    private static void handleItem(Signal signal, Object... target) {

    }

    private static void handleLocation(Signal signal, Object... target) {
        switch (signal) {
            case LOCATIONADDED -> LocationManager.addLocation(signal.getEmitterLocation());
        }
    }
}

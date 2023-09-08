package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.arran.Signal;

public class SignalManager {
    public static void receiveSignal(Signal signal, Object... args) {
        switch (signal.getType().getGroup()) {
            case BEING -> handleBeing(signal, args);
            case ITEM -> handleItem(signal, args);
            case LOCATION -> handleLocation(signal, args);
        }
    }

    private static void channelSignal() {
        //
    }

    private static void handleBeing(Signal signal, Object... args) {
        switch (signal.getType()) {
            case DIED -> {
                if (signal.getEmitterBeing().equals(GameManager.getPlayer())) { // If player died
                    GameManager.end();
                }
                else if (GameManager.getGameState() == GameManager.State.COMBAT) {
                    GameManager.Fight.end();
                }
            }
            case ATTACKED -> {
                // attacked.emit(this, int damage) <- it has damage integer as an arg
                if (GameManager.Fight.isPlayersTurn()) {
                    GameManager.Fight.getOpponent().takeDamage((int) args[0]);
                }
                else {
                    GameManager.getPlayer().takeDamage((int) args[0]);
                }
            }
            case DEFENDED -> {
                // Do nothing
            }
            case FLED -> System.out.println("Just signalled FLED, WIP"); // TODO
            case LOOTED -> {

            }
        }
    }

    private static void handleItem(Signal signal, Object... target) {

    }

    private static void handleLocation(Signal signal, Object... target) {
        switch (signal.getType()) {
            case LOCATIONADDED -> LocationManager.addLocation(signal.getEmitterLocation());
        }
    }
}

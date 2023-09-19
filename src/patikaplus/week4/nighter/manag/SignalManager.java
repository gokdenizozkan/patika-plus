package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.arran.Signal;
import patikaplus.week4.nighter.blup.Vessel;

public class SignalManager {
    public static void receiveSignal(Signal signal, Object... args) {
        switch (signal.getType().getGroup()) {
            case BEING -> handleBeing(signal, args);
            case ITEM -> handleItem(signal, args);
            case LOCATION -> handleLocation(signal, args);
            case SCENE -> handleScene(signal, args);
        }
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
            // DEFEND action is passive, so it does not need a function call, thus no "case DEFENDED" needed.
            case FLED -> GameManager.Fight.end();
            case LOOTED -> {
                // TODO no priority atm : Loot from enemies already implemented
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
    
    private static void handleScene(Signal signal, Object... args) {
    	switch (signal.getType()) {
    		case CHARACTERCREATED -> {
    			// if for player
    			if ((Boolean) args[0]) GameManager.createPlayer((String) args[1], (Vessel) args[2]);
    			else GameManager.createBeing((String) args[1], (Vessel) args[2]);
    		}
    	}
    }
}

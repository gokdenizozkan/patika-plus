package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.blup.Location;
import patikaplus.week4.nighter.prod.Cave;
import patikaplus.week4.nighter.prod.Enemy;
import patikaplus.week4.nighter.prod.Player;
import patikaplus.week4.nighter.util.Tengri;

import java.util.ArrayList;

public class GameManager {
    private enum State {
        FREE, COMBAT;
    }

    private static Player player;
    private static State gameState;

    protected static void start() {
        // START GAME
    }

    protected static void end() {
        // GAME OVER
    }

    protected static void tick() {
        // UPDATE COMPONENTS OF THE GAME
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////// COMBAT \\\
    private Battle currentCombat;
    protected void startNewBattle() throws Exception {
        currentCombat = new Battle();
        gameState = State.COMBAT;
    }

    protected void endBattle() {
        currentCombat = null;
        gameState = State.FREE;
    }

    class Battle {
        Being opponent;
        Boolean playersTurn;

        Battle() throws Exception {
            playersTurn = Tengri.flipCoin();
            Enemy b = (Enemy) new Cave().getBeingExcept(new Enemy());
            b.enemySpecific();
        }

    }

    protected static Player getPlayer() {
        return player;
    }
}

package patikaplus.week4.nighter.manag;

import patikaplus.week4.nighter.blup.Being;
import patikaplus.week4.nighter.util.Input;
import patikaplus.week4.nighter.util.Print;
import patikaplus.week4.nighter.util.Tengri;

public class GameManager {
    protected enum State {
        FREE, COMBAT;
    }

    private static Being player;
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
    public static class Fight {
        private static Fight currentFight;
        private static Being opponent;
        private static Boolean playersTurn;
        public enum Action {
            ATTACK, DEFEND, FLEE;

            public static final int length;
            private static String[] names;
            private static Action[] actions;

            static {
                init();
                length = Action.getNames().length;
            }

            private static void init() {
                Action[] values = values();
                String[] names = new String[values.length];
                for (int i = 0; i < values.length; i++) {
                    names[i] = values[i].name();
                }
                Action.names = names;
                Action.actions = values;
            }

            public static String[] getNames() {
                return names;
            }

            public static Action[] getActions() {
                return actions;
            }
        }

        Fight() throws Exception {
            playersTurn = Tengri.flipCoin();
            opponent = LocationManager.getEnemy();
        }

        private static void loop() {
            Being actor = playersTurn ? player : opponent;
            Action action = playersTurn ? Input.Player.getAction() : Input.Ai.getAction();

            Print.Nighter.Ui.combat();
            switch (action) {
                case ATTACK -> actor.attack();
                case DEFEND -> actor.defend();
                case FLEE -> actor.flee();
            }
            nextTurn();
        }

        protected static void start() throws Exception {
            currentFight = new Fight();
            gameState = State.COMBAT;
            loop();
        }

        protected static void end() {
            currentFight = null;
            gameState = State.FREE;
            if (isThereAnyDead()) {
                opponent.getInventory().transferAll(player.getInventory());
            }
        }

        protected static boolean isPlayersTurn() {
            return playersTurn;
        }

        protected static boolean isThereAnyDead() {
            return (player.isDead() || opponent.isDead());
        }

        protected static Being getOpponent() {
            return opponent;
        }

        protected static void nextTurn() {
            playersTurn = !playersTurn;
            loop();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////// Misc \\\
    protected static Being getPlayer() {
        return player;
    }

    protected static State getGameState() {
        return gameState;
    }
}

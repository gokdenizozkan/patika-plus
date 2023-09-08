package patikaplus.week4.nighter.util;

import patikaplus.week4.nighter.manag.GameManager.Fight.Action;
import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static int getSelection() {
        // Returns the input by decreasing it by 1
        return sc.nextInt() - 1;
    }

    public static String getLine() {
        return sc.nextLine();
    }

    public static class Player {
        public static Action getAction() {
            Print.options(Action.getNames());

            int input = getSelection();
            for (int i = 0; i < Action.length; i++) {
                if (input == i) {
                    return Action.getActions()[i];
                }
            }
            return null;
        }
    }

    public static class Ai {
        public static Action getAction() {
            return Action.getActions()
                    [Tengri.range(
                        Action.length)];
        }
    }
}

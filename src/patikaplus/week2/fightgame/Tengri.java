package patikaplus.week2.fightgame;

import java.util.Random;

public class Tengri {
    static Random dice = new Random();

    public static boolean flipCoin() {
        return dice.nextBoolean();
    }
}

package com.gokdenizozkan.util;

import java.util.Random;

public class Tengri {
    static Random dice = new Random();

    public static boolean flipCoin() {
        return dice.nextBoolean();
    }

    public static int range(int max) {
        return dice.nextInt(max);
    }

    public static int range(int min, int max) {
        return dice.nextInt(min, max);
    }
}

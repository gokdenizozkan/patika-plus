package dev.patika.plus.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ChineseZodiacFinder {
    public static void run() {
        Map<Byte, String> chineseZodiacs = new HashMap<>();
        Scanner input = new Scanner(System.in);

        String[] chineseZodiacNames = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat"};
        for (byte i = 0; i < chineseZodiacNames.length; i++) {
            chineseZodiacs.put(i, chineseZodiacNames[i]);
        }

        System.out.println("Please type your birth year in:");
        System.out.println("Your Chinese Zodiac is " + chineseZodiacs.get((byte) (input.nextInt() % 12)));
    }
}

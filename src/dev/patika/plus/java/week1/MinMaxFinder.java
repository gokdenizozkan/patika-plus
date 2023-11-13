package dev.patika.plus.java.week1;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxFinder {
    public static void run() {
        long[] numbers;
        Scanner input = new Scanner(System.in);

        System.out.println("How many numbers will you type in?");
        numbers = new long[input.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Please type the number " + (i + 1) + " in:");
            numbers[i] = input.nextLong();
        }

        System.out.println("Min number: " + Arrays.stream(numbers).min().getAsLong() + "\nMax number: " + Arrays.stream(numbers).max().getAsLong());
    }
}

package dev.patika.plus.week1.java101;

import java.util.Scanner;

public class HarmonicSeriesFinder {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        double in, sum = 0;
        System.out.println("Please enter a number to find its Harmonic Series:");
        in = sc.nextDouble();

        for (int i = 1; i <= in; i++) {
            if (i != 1) System.out.print(" + "); // Skip the first print

            double seriesElement = 1.0f / i;
            System.out.print(seriesElement);
            sum += seriesElement;
        }

        System.out.println("\n=> " + sum);
    }
}

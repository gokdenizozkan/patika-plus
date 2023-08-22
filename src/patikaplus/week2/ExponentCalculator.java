package patikaplus.week2;

import java.util.Scanner;

public class ExponentCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        long base, exponent;
        System.out.println("Please enter the base value:");
        base = sc.nextLong();

        System.out.println("Please enter the exponent value:");
        exponent = sc.nextLong();

        System.out.println(base + "^" + exponent + " = " + calculateExponentRecursively(base, exponent));
    }

    public static long calculateExponentRecursively(long base, long exponent) {
        if (exponent == 1) {
            return base;
        }
        return base * calculateExponentRecursively(base, exponent - 1);
    }
}

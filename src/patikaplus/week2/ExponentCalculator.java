package patikaplus.week2;

import java.util.Scanner;

public class ExponentCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int base, exponent;
        System.out.println("Please enter the base value:");
        base = sc.nextInt();

        System.out.println("Please enter the exponent value:");
        exponent = sc.nextInt();

        System.out.println(base + "^" + exponent + " = " + (long) (Math.pow(base, exponent)));
    }
}

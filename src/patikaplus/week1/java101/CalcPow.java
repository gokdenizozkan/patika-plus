package patikaplus.week1.java101;

import java.util.Scanner;

public class CalcPow {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        long base;
        int exponent;
        System.out.println("Please enter a base number:");
        base = sc.nextLong();

        System.out.println("Please enter the exponent value:");
        exponent = sc.nextInt();

        System.out.println(calcPow(base, exponent));
    }

    private static long calcPow(long base, int exponent) {
        long num = base; // return num

        for (int i = 1; i < exponent; i++) {
            num *= base;
        }

        return num;
    }
}

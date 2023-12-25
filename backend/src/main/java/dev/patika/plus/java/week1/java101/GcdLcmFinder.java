package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class GcdLcmFinder {
    // 2 * 3^2 * 7^3
    // 2^3 * 7^2
    // EBOB EKOK
    private static final Scanner sc = new Scanner(System.in);
    private static long gcd;
    private static long lcm;

    public static void run() {
        int n1, n2;
        System.out.println("Num 1:");
        n1 = sc.nextInt();

        System.out.println("Num 2:");
        n2 = sc.nextInt();

        System.out.println("GCD is " + findGcd(n1, n2));
        System.out.println("LCM is " + findLcm(n1, n2, gcd));
    }

    public static long findGcd(int a, int b) {
        // Implemented while loop for the sake of assignment
        long i = 1;
        while (i < Integer.min(a, b)) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
            i++;
        }
        return gcd;
    }

    public static long findLcm(int a, int b, long gcd) {
        lcm = ((long) a * b) / gcd;
        return lcm;
    }
}

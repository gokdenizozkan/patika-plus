package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class PrintPow45TilN {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        long num, p4 = 4, p5 = 5;

        System.out.println("Please enter a number:");
        num = sc.nextLong();

        do {
            if (p4 < num) {
                System.out.print(p4 + " ");
            }
            if (p5 < num) {
                System.out.print(p5 + " ");
            }
            p4 *= 4;
            p5 *= 5;
            System.out.println();
        } while (p4 < num || p5 < num);
    }
}

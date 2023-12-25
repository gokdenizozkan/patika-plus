package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class PrintEvenNumsMod34 {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        int num, length = 0, sum = 0;
        System.out.println("Please enter a number:");
        num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            if (i % 3 == 0 || i % 4 == 0) {
                sum += i;
                length++;
            }
        }

        System.out.println("Avg. of nums: " + (sum/length));
    }
}

package dev.patika.plus.week1;

import java.util.Scanner;

public class DrawUpsideDownTriangle {
    public static void run() {
        Scanner input = new Scanner(System.in);
        int baseLength, starCount;

        System.out.println("How many stars should the base length of the triangle be?");
        baseLength = input.nextInt();

        for (int i = 0; i < baseLength; i++) {
            // Print baseLength - 2*/loop amount of *
            starCount = baseLength - (i * 2);
            if (starCount < 1) break;

            for (int j = 0; j < i; j++) {
                System.out.print((" "));
            }

            for (int j = starCount; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}

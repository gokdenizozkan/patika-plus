package dev.patika.plus.java.week2;

import java.util.Scanner;

public class BackAndForthPatternPrinter {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int input, pattern = -5;

        System.out.println("Entering a positive number will print its pattern.\nDefault pattern is -5.\nTo change the pattern, type -1\n\nPlease enter your prompt:");
        input = sc.nextInt();

        if (input == -1) {
            System.out.println("\nPattern should be a negative value.\nPlease enter the new pattern:");
            pattern = sc.nextInt();

            System.out.println("\nPlease enter a positive number to print its pattern:");
            input = sc.nextInt();
        }

        printBackAndForthPattern(input, pattern);
    }

    private static void printBackAndForthPattern(int originalNumber, int pattern, int... recursedNum) {
        int num = recursedNum.length == 0 ? originalNumber : recursedNum[0];
        System.out.print(num);

        if (recursedNum.length > 0 && num == originalNumber) return;
        System.out.print(" ");

        if (num <= 0) pattern = -(pattern);
        printBackAndForthPattern(originalNumber, pattern, num + pattern);
    }
}

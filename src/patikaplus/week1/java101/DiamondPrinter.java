package patikaplus.week1.java101;

import java.util.Scanner;

public class DiamondPrinter {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        int size;

        System.out.println("Enter the size of the diamond:");
        size = sc.nextInt();

        // Upper triangle
        for (int i = 1; i <= size; i++) {
            printTriangle(size, i);
        }

        // Lower triangle
        for (int i = (size - 1); i >= 1; i--) {
            printTriangle(size, i);
        }
    }

    private static void printTriangle(int size, int i) {
        for (int j = 1; j <= (size - i); j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= ((2 * i) - 1); j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

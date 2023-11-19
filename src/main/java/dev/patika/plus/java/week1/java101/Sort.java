package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class Sort {
    private final static Scanner sc;
    private final static int length;
    private final static int[] inputs;
    private final static int[] indexesSorted;
    private final static int[] inputsSorted;

    static {
        sc = new Scanner(System.in);

        System.out.println("Please enter the amount of numbers to be sorted:");
        length = sc.nextInt();

        inputs = new int[length];
        indexesSorted = new int[length];
        inputsSorted = new int[length];
    }

    public static void run() {
        // Take inputs
        for (int i = 0; i < length; i++) {
            System.out.println("Num " + (i + 1) + ":");
            inputs[i] = sc.nextInt();
        }

        // Sort
        sort();

        System.out.println("\n\n\n\n\n\n\n\n\n"); // Clear screen

        System.out.println("Not sorted:");
        printArray(inputs);
        System.out.println("Sorted:");
        printArray(inputsSorted);
    }

    private static void sort() {
        // Find sorted indexes of all the inputs
        for (int i = 0; i < length; i++) { // For every integer in inputs
            int input = inputs[i]; // For easy access and more readability, I explicitly defined the current input
            int index = (length - 1);

            for (int j : inputs) {
                if (input == j) continue;
                if (input < j) index--;
            }

            indexesSorted[i] = index;
        }

        // According to sorted indexes, create the sorted inputs array
        for (int i = 0; i < length; i++) {
            inputsSorted[i] = inputs[
                    indexesSorted[i]];
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
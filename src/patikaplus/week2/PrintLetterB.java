package patikaplus.week2;

import patikaplus.Util;

public class PrintLetterB {
    public static void run() {
        // use of 2D array is only for the given problem, it is not necessary.
        System.out.println("Please enter the size of your letter B:\n(should be an even number\nand greater than or equal to 2)");
        int size = Util.getInputInt(); // size should be even and greater than or equal to 2
        int[][] letter = new int[size - 1][size];
        int sizeR = letter.length;
        int incrementor = (size/2) - 1; // for sizeR is an odd number, possible full line stars are found in this calc.

        row:
        for (int r = 0; r < sizeR; r++) {
            System.out.println();

            // Print full line stars
            for (int s = 0; s < size; s += incrementor) {
                if (r == s) {
                    print("*", size - 1);
                    continue row;
                }
            }

            // Print spaces and outer stars
            print("*", 1);
            print(" ", size - 1);
            print("*", 1);
        }
    }

    private static void print(String str, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(str);
        }
    }
}

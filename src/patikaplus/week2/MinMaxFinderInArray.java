package patikaplus.week2;

import patikaplus.util;

public class MinMaxFinderInArray {
    public static void run() {
        System.out.println("Please enter your data set by separating them with spaces:");
        int[] in = util.parseIntArray(util.getInputsBySpace());
        System.out.printf("Min: %d\nMax: %d", min(in), max(in));
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

    private static int min(int[] arr) {
        int m = arr[0];
        for (int i : arr) {
            if (i < m) {
                m = i;
            }
        }
        return m;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static int max(int[] arr) {
        int m = arr[0];
        for (int i : arr) {
            if (i > m) {
                m = i;
            }
        }
        return m;
    }
}

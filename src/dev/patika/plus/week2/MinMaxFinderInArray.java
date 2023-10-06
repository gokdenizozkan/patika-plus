package dev.patika.plus.week2;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Parse;

public class MinMaxFinderInArray {
    public static void run() {
        int[] in = Parse.toArrayInt(Input.getLine(' ', "Please enter your data set by separating them with spaces:"));
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

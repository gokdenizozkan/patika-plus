package patikaplus;

import java.util.Scanner;

public class util {
    private static final Scanner sc = new Scanner(System.in);

    public static String[] getInputsBySpace() {
        return sc.nextLine().trim().split(" ");
    }

    public static double[] parseDoubleArray(String[] strArray) {
        int len = strArray.length;
        double[] doubleArray = new double[len];

        for (int i = 0; i < len; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }

        return doubleArray;
    }

    public static int[] parseIntArray(String[] strArray) {
        int len = strArray.length;
        int[] intArray = new int[len];

        for (int i = 0; i < len; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }
}

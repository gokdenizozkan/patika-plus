package patikaplus.week2;

import java.util.Scanner;

public class ArrayHarmonicSeriesCalculator {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        System.out.println("Please enter the numbers for your data set:\n(separate them with spaces: 10 20 30 ...)");
        System.out.println(
                calcHarmonicMean(
                        parseDoubleArray(
                                sc.nextLine()
                                        .trim().split(" "))));
    }

    private static double[] parseDoubleArray(String[] strArray) {
        int len = strArray.length;
        double[] doubleArray = new double[len];

        for (int i = 0; i < len; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }

        return doubleArray;
    }
    private static double calcHarmonicMean(double[] xArray) {
        double sum = 0;

        for (double x : xArray) {
            sum += 1/x;
        }

        return xArray.length / sum;
    }
}

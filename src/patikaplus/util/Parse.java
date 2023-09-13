package patikaplus.util;

public class Parse {
    public static double[] toArrayDouble(String[] strArray) {
        int len = strArray.length;
        double[] doubleArray = new double[len];

        for (int i = 0; i < len; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }

        return doubleArray;
    }

    public static int[] toArrayInt(String[] strArray) {
        int len = strArray.length;
        int[] intArray = new int[len];

        for (int i = 0; i < len; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }
}

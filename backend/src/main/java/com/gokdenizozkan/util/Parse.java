package com.gokdenizozkan.util;

public class Parse {
    public static double[] toArrayDouble(String[] arr) {
        int len = arr.length;
        double[] arrReturn = new double[len];

        for (int i = 0; i < len; i++) {
            arrReturn[i] = Double.parseDouble(arr[i]);
        }

        return arrReturn;
    }

    public static int[] toArrayInt(String[] arr) {
        int len = arr.length;
        int[] arrReturn = new int[len];

        for (int i = 0; i < len; i++) {
            arrReturn[i] = Integer.parseInt(arr[i]);
        }

        return arrReturn;
    }

    public static Integer[] toArrayInteger(String[] arr) {
        int len = arr.length;
        Integer[] arrReturn = new Integer[len];

        for (int i = 0; i < len; i++) {
            arrReturn[i] = Integer.parseInt(arr[i]);
        }

        return arrReturn;
    }
}

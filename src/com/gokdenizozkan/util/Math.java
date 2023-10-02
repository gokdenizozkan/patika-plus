package com.gokdenizozkan.util;

public class Math {
    // MIN MAX

    /**
     * Returns the minimum integer value between the given two integers as params.
     * @param a first integer
     * @param b second integer
     * @return the param whose value is lower than the other
     */
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    /**
     * Returns the minimum integer value in the given array.
     * @param arr holding integer values to be compared.
     * @return the minimum value found in the array given as param.
     */
    public static int min(int[] arr) {
        int m = arr[0];
        for (int i : arr) m = (i < m) ? i : m;
        return m;
    }

    /**
     * Returns the maximum integer value between the given two integers as params.
     * @param a first integer
     * @param b second integer
     * @return the param whose value is higher than the other
     */
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * Returns the maximum integer value in the given array.
     * @param arr holding integer values to be compared.
     * @return the maximum value found in the array given as param.
     */
    public static int max(int[] arr) {
        int m = arr[0];
        for (int i : arr) m = (i > m) ? i : m;
        return m;
    }

    // POW

    /**
     * Returns the long value of base, multiplied by itself for the given exponent param times.
     * @param base a number to be multiplied by itself.
     * @param exponent decides how many times will the base be multiplied by itself.
     * @return long value of base, multiplied by itself for param exponent times.
     */
    public static long pow(long base, int exponent) {
    	if (base == 1 || exponent == 0) return 1;
    	if (base == 0 || exponent == 1) return base;
    	
        long num = base; // return num
        for (int i = 1; i < exponent; i++) num *= base;
        return num;
    }
    

    /**
     * Returns the integer value of base, multiplied by itself for the given exponent param times.
     * @param base a number to be multiplied by itself.
     * @param exponent decides how many times will the base be multiplied by itself.
     * @return integer value of base, multiplied by itself for param exponent times.
     */
    public static int pow(int base, int exponent) {
    	if (base == 1 || exponent == 0) return 1;
    	if (base == 0 || exponent == 1) return base;
    	
        int num = base; // return num
        for (int i = 1; i < exponent; i++) num *= base;
        return num;
    }
}

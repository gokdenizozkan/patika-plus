package patikaplus.util;

public class Array {
    public static String reverse(String str) {
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        char[] reversed = new char[len];

        len--; // to make it index
        for (int i = len; i >= 0; i--) {
            reversed[len - i] = charArr[i];
        }
        return String.valueOf(reversed);
    }

    public static char[] reverse(char[] charArr) {
        int len = charArr.length;
        char[] reversed = new char[len];

        len--; // to make it index
        for (int i = len; i >= 0; i--) {
            reversed[len - i] = charArr[i];
        }
        return reversed;
    }

    public static int[] reverse(int[] intArr) {
        int len = intArr.length;
        int[] reversed = new int[len];

        len--; // to make it index
        for (int i = len; i >= 0; i--) {
            reversed[len - i] = intArr[i];
        }
        return reversed;
    }

    public static boolean doesContain(int[] arr, int i) {
        for (int e : arr) {
            if (e == i) return true;
        }
        return false;
    }

    public static boolean doesContain(Integer[] arr, Integer i) {
        for (Integer integer : arr) {
            if (integer == null) continue;
            if (integer.equals(i)) return true;
        }
        return false;
    }

    public static int recurrenceCount(int[] arr, int element) {
        int count = 0;
        for (int e : arr) {
            if (e == element) count++;
        }
        return count;
    }

    public static int recurrenceCount(Integer[] arr, int element) {
        int count = 0;
        for (int e : arr) {
            if (e == element) count++;
        }
        return count;
    }

    private static Integer[] uniques(Integer[] arr) {
        Integer[] uniques = new Integer[arr.length];
        uniques[0] = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (Array.doesContain(uniques, arr[i])) continue;
            uniques[i] = arr[i];
        }
        return nonNullify(uniques);
    }

    /**
     * Resizes the given arr to get rid of its null objects.
     */
    public static Integer[] nonNullify(Integer[] arr) {
        int len = arr.length;
        int[] arrMap = new int[len];
        int nullCount = 0;

        // Find nullCount and map the arr
        for (int i = 0; i < len; i++) {
            if (arr[i] == null) {
                nullCount++;
                arrMap[i] = 0;
                continue;
            }
            arrMap[i] = 1;
        }

        Integer[] nonNullifiedArr = new Integer[len - nullCount];
        int i = 0;
        for (int e = 0; e < len; e++) {
            if (arrMap[e] == 0) continue;
            nonNullifiedArr[i] = arr[e];
            i++;
        }

        return nonNullifiedArr;
    }
}

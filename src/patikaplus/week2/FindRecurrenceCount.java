package patikaplus.week2;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Array;

public class FindRecurrenceCount {
    public static void run() { // 1 2 3 4 5 6 7 8 9 10 1 2 3 4 5
        Integer[] ins = toArrayInteger(Input.getLine(' ', "Please enter your data set separated by spaces:"));
        Integer[] uniqs = uniques(ins);

        System.out.println("Recurrence Counts:");
        for (Integer u : uniqs) {
            System.out.printf("Recurrence count of %d is %d.", u, countRecurrences(ins, u));
            System.out.println();
        }
    }

    private static int countRecurrences(Integer[] arr, int element) {
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
            if (Array.contains(uniques, arr[i])) continue;
            uniques[i] = arr[i];
        }
        return nonNullify(uniques);
    }

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

    public static Integer[] toArrayInteger(String[] strArray) {
        int len = strArray.length;
        Integer[] intArray = new Integer[len];

        for (int i = 0; i < len; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }
}

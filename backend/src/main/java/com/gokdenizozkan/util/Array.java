package com.gokdenizozkan.util;

public class Array <T> extends Object {
    // COPY
    public static <T> T[] copyAndEnlarge(T[] arr, int enlargeAmount, boolean enlargeEnd) {
        T[] enlargedArr = (T[]) new Object[arr.length + enlargeAmount];

        int iStart; // start index
        if (enlargeEnd) iStart = 0;
        else iStart = enlargeAmount;

        for (int i = 0; i < arr.length; i++) {
            enlargedArr[iStart] = arr[i];
            iStart++;
        }
        return enlargedArr;
    }
    
    /**
     * Removes the given object and resizes the array accordingly (-1).
     * Limitations: Object to be removed will be the first occurrence in the array.
     * @param arr mentioned array.
     * @param remove object to be removed.
     * @return a resized array without the object.
     */
    public static <T> T[] removeAndNarrow(T[] arr, int remove) {
    	T[] narrowed = (T[]) new Object[arr.length - 1];
    	int iRemove = indexOf(arr, remove);
    	
    	for (int i = 0; i < narrowed.length; i++) {
    		if (i >= iRemove) narrowed[i] = arr[i + 1];
    		else narrowed[i] = arr[i];
    	}
    	return narrowed;
    }
    
    // INDEX OF
    /**
     * Returns the index of the given object.
     * @param arr array to search for.
     * @param object to be found in the array.
     * @return index of the given object. -1 if object is not found.
     */
    public static <T> int indexOf(T[] arr, T object) {
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == object) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    // SORT
    public static int[] sort(int[] arr) {
        int length = arr.length;
        int[] indexesSorted = new int[length];
        int[] sorted = new int[length];

        // Find sorted indexes of all the inputs
        for (int i = 0; i < length; i++) { // For every integer in inputs
        	int element = arr[i]; // For easy access and more readability, I explicitly defined the current input
            int index = (length - 1);

            for (int e : arr) {
                if (element == e) continue;
                if (element < e) index--;
            }
            indexesSorted[i] = index;
        }

        // According to sorted indexes, create the sorted inputs array
        for (int i = 0; i < length; i++) {
            sorted[i] = arr[
                    indexesSorted[i]];
        }
        return sorted;
    }

    public static float[] sort(float[] arr) {
        int length = arr.length;
        int[] indexesSorted = new int[length];
        float[] sorted = new float[length];

        // Find sorted indexes of all the inputs
        for (int i = 0; i < length; i++) { // For every integer in inputs
        	float element = arr[i]; // For easy access and more readability, I explicitly defined the current input
            int index = (length - 1);

            for (float e : arr) {
                if (element == e) continue;
                if (element < e) index--;
            }
            indexesSorted[i] = index;
        }

        // According to sorted indexes, create the sorted inputs array
        for (int i = 0; i < length; i++) {
            sorted[i] = arr[
                    indexesSorted[i]];
        }
        return sorted;
    }

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
    
    public static <T> T[] reverse(T[] arr) {
        int len = arr.length;
        T[] reversed = (T[]) new Object[len];

        len--; // to make it index
        for (int i = len; i >= 0; i--) {
            reversed[len - i] = arr[i];
        }
        return reversed;
    }
    
    public static <T> boolean contains(T[] arr, T element) {
        for (T e : arr) {
            if (e == element) return true;
        }
        return false;
    }
    
    /**
     * Returns recurring count of the given element in an array.
     * @param <T> type
     * @param arr array
     * @param element recurring element
     * @return recurrence count
     */
    public static <T> int recurrenceCount(T[] arr, T element) {
        int count = 0;
        for (T e : arr) {
            if (e == element) count++;
        }
        return count;
    }

    /**
     * Returns an array of given type with no repetitive elements. Dependent on @method nonNullify.
     * @param arr
     * @return an array of given type with no repetitive elements.
     */
    private static <T> T[] uniques(T[] arr) {
        T[] uniques = (T[]) new Object[arr.length];
        uniques[0] = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (Array.contains(uniques, arr[i])) continue;
            uniques[i] = arr[i];
        }
        return nonNullify(uniques);
    }

    /**
     * Resizes the given arr to get rid of its null objects.
     */
    public static <T> T[] nonNullify(T[] arr) {
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

        T[] nonNullifiedArr = (T[]) new Object[len - nullCount];
        int i = 0;
        for (int e = 0; e < len; e++) {
            if (arrMap[e] == 0) continue;
            nonNullifiedArr[i] = arr[e];
            i++;
        }

        return nonNullifiedArr;
    }
}

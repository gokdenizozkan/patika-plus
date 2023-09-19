package patikaplus.util;

public class Array {
    // COPY
    public static int[] copyAndEnlarge(int[] arr, int enlargeAmount, boolean enlargeEnd) {
        int[] enlargedArr = new int[arr.length + enlargeAmount];

        int iStart; // start index
        if (enlargeEnd) iStart = 0;
        else iStart = enlargeAmount;

        for (int i = 0; i < arr.length; i++) {
            enlargedArr[iStart] = arr[i];
            iStart++;
        }
        return enlargedArr;
    }
    
    public static Object[] copyAndEnlarge(Object[] arr, int enlargeAmount, boolean enlargeEnd) {
    	Object[] enlargedArr = new Object[arr.length + enlargeAmount];

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
    public static int[] removeAndNarrow(int[] arr, int remove) {
    	int[] narrowed = new int[arr.length - 1];
    	int iRemove = indexOf(arr, remove);
    	
    	for (int i = 0; i < narrowed.length; i++) {
    		if (i >= iRemove) narrowed[i] = arr[i + 1];
    		else narrowed[i] = arr[i];
    	}
    	return narrowed;
    }
    
    /**
     * Removes the given object and resizes the array accordingly (-1).
     * Limitations: Object to be removed will be the first occurrence in the array.
     * @param arr mentioned array.
     * @param remove object to be removed.
     * @return a resized array without the object.
     */
    public static Object[] removeAndNarrow(Object[] arr, int remove) {
    	Object[] narrowed = new Object[arr.length - 1];
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
    public static int indexOf(int[] arr, int object) {
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == object) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    
    // INDEX OF
    /**
     * Returns the index of the given object.
     * @param arr array to search for.
     * @param object to be found in the array.
     * @return index of the given object. -1 if object is not found.
     */
    public static int indexOf(Object[] arr, Object object) {
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
            int input = arr[i]; // For easy access and more readability, I explicitly defined the current input
            int index = (length - 1);

            for (int in : arr) {
                if (input == in) continue;
                if (input < in) index--;
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
            float input = arr[i]; // For easy access and more readability, I explicitly defined the current input
            int index = (length - 1);

            for (float in : arr) {
                if (input == in) continue;
                if (input < in) index--;
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////// REVERSE ///
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

    public static Object[] reverse(Object[] intArr) {
        int len = intArr.length;
        Object[] reversed = new Object[len];

        len--; // to make it index
        for (int i = len; i >= 0; i--) {
            reversed[len - i] = intArr[i];
        }
        return reversed;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////// DOES CONTAIN ///
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

    /////////////////////////////////////////////////////////////////////////////////////////////// RECURRENCE COUNT ///
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////// UNIQUES ///

    /**
     * Returns an array of given type with no repetitive elements. Dependent on @method nunNullify.
     * @param arr
     * @return an array of given type with no repetitive elements.
     */
    private static Integer[] uniques(Integer[] arr) {
        Integer[] uniques = new Integer[arr.length];
        uniques[0] = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (Array.doesContain(uniques, arr[i])) continue;
            uniques[i] = arr[i];
        }
        return nonNullify(uniques);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////// NON NULLIFY ///
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
    
    public static String[] nonNullify(String[] arr) {
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

        String[] nonNullifiedArr = new String[len - nullCount];
        int i = 0;
        for (int e = 0; e < len; e++) {
            if (arrMap[e] == 0) continue;
            nonNullifiedArr[i] = arr[e];
            i++;
        }

        return nonNullifiedArr;
    }
}

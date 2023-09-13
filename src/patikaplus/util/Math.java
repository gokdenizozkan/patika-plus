package patikaplus.util;

public class Math {
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int min(int[] arr) {
        int m = arr[0];
        for (int i : arr) {
            if (i < m) {
                m = i;
            }
        }
        return m;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int max(int[] arr) {
        int m = arr[0];
        for (int i : arr) {
            if (i > m) {
                m = i;
            }
        }
        return m;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////// Other ///
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

}

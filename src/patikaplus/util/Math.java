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
}

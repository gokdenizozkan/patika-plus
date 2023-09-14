package patikaplus.util;

public class Print {
    public static void array(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////// line ///
    public static void nline(String str) {
        System.out.println(str);
    }

    public static void nline(String str, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.println(str);
        }
    }

    public static void line(String str, String beg, String end) {
        System.out.print(beg + str + end);
    }

    public static void line(String str, String end) {
        System.out.print(str + end);
    }

    public static void line(String str, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(str);
        }
    }

    public static void line(char c, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(c);
        }
    }

    public static void fline(String str, Object... formatting) {
        System.out.printf(str, formatting);
    }

    public static void fline(int amount, String str, Object... formatting) {
        for (int t = 0; t < amount; t++) {
            System.out.printf(str, formatting);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////// num ///
    public static void num(int i, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(i);
        }
    }

    public static void num(float f, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(f);
        }
    }

    public static void num(long l, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(l);
        }
    }

    public static void num(double d, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(d);
        }
    }

}

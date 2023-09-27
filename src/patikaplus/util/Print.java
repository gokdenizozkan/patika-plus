package patikaplus.util;

public class Print <T> extends Object {
    public static <T> void array(T[] arr) {
        for (T e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // LINE
    
    public static void line(int i) {
        System.out.print(i);
    }

    public static void line(String str) {
        System.out.print(str);
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

    public static void line(String str, String beg, String end) {
        System.out.print(beg + str + end);
    }

    public static void line(String str, String end) {
        System.out.print(str + end);
    }

    public static void nline(String str) {
        System.out.println(str);
    }
    
    public static void nline(int num) {
        System.out.println(num);
    }

    public static void nline(String str, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.println(str);
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

    public static void nfline(String str, Object... formatting) {
        System.out.printf(str + "\n", formatting);
    }

    public static void nfline(int amount, String str, Object... formatting) {
        for (int t = 0; t < amount; t++) {
            System.out.printf(str + "\n", formatting);
        }
    }

    // NUM
    public static void num (int i) {
        System.out.print(i);
    }
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

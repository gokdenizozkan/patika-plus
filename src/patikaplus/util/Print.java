package patikaplus.util;

public class Print {
    /////////////////////////////////////////////////////////////////////////////////////////////////////////// line ///
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

package patikaplus.util;

public class Print {
    public static void line(String str, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(str);
        }
    }

    public static void line(char c, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(c);
        }
    }


}

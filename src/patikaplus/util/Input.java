package patikaplus.util;

import java.util.Scanner;

public class Input {
    private static Scanner sc;

    // Initializes class attributes (like Scanner sc)
    static {
        new Input();
    }

    // To reinitialize the class if needed
    private Input() {
        sc = new Scanner(System.in);
    }

    // Methods
    public static int getInt(String... ask) {
        if (!isEmpty(ask)) System.out.println(ask[0]);
        return sc.nextInt();
    }

    public static String getLine(String... ask) {
        if (!isEmpty(ask)) System.out.println(ask[0]);
        return sc.nextLine();
    }

    public static String[] getLine(char separator, String... ask) {
        if (!isEmpty(ask)) System.out.println(ask[0]);
        return sc.nextLine().trim().split(String.valueOf(separator));
    }

    // Misc

    /**
     * Resets the scanner by reinitializing the class to avoid buffer issues.
     */
    public static void resetScanner() {
        new Input();
    }

    private static boolean isEmpty(String[] arr) {
        return arr.length == 0;
    }
}

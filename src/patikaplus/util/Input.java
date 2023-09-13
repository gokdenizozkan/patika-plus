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
    public static int getInputInt() {
        return sc.nextInt();
    }

    public static String[] getInputsBySpace() {
        return sc.nextLine().trim().split(" ");
    }

    // Misc
    public static void resetScanner() {
        new Input();
    }
}

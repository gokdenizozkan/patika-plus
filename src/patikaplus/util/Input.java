package patikaplus.util;

import java.util.Scanner;

public class Input <T> extends Object {
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
    
    /**
     * Returns the option user selected.
     * @param <T> type
     * @param question 
     * @param options
     * @return selection
     */
    public static <T> T ask(String question, T... options) {
    	System.out.println(question);
        for (int i = 0; i < options.length; i++) {
        	System.out.printf("%d > %s\n", i + 1, options[i].toString());
        }
        
        return options[sc.nextInt() - 1];
    }

    // Misc

    /**
     * Resets the scanner by reinitializing the class to avoid buffer issues.
     */
    public static void resetScanner() {
        new Input();
    }
    
    /**
     * Gets user input as a line and it is empty ("") safe
     * @return
     */
    public static String getLineEmptySafe() {
        String s;
        do {
            s = sc.nextLine();
        } while (s.equals(""));
        return s;
    }

    private static <T> boolean isLengthZero(T[] arr) {
        return arr.length == 0;
    }

    private static <T> boolean isEmpty(T[] arr) {
        for (T e : arr) {
        	if (e != null) return false;
        }
        return true;
    }
    
    
}

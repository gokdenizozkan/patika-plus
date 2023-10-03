package com.gokdenizozkan.util;

import java.util.Scanner;
import java.util.function.Function;

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
    public static int getInt(String ask) {
        System.out.print(ask + " ");
        return sc.nextInt();
    }

    public static float getFloat(String ask) {
        System.out.print(ask + " ");
        return sc.nextInt();
    }
    
    public static String getLine(String ask) {
        System.out.print(ask + " ");
        return sc.nextLine();
    }

    public static String[] getLine(char separator, String ask) {
        System.out.print(ask + " ");
        return sc.nextLine().trim().split(String.valueOf(separator));
    }

    public static String[] getLine(String separator, String ask) {
        System.out.println(ask);
        return sc.nextLine().trim().split(separator);
    }
    
    /**
     * Returns the option user selected.
     * @param <T> type
     * @param question to lead the user to select an appropriate option.
     * @param options user can select.
     * @return selection in the type it was given as an option
     */
    public static <T> T ask(String question, T[] options) {
    	System.out.println(question);
        for (int i = 0; i < options.length; i++) {
        	System.out.printf("%d > %s\n", i + 1, options[i].toString());
        }
        
        return options[sc.nextInt() - 1];
    }
    
    /**
     * Returns the option user selected.
     * @param <T> type
     * @param question to lead the user to select an appropriate option.
     * @param options user can select.
     * @param visualRepresentation A lambda expression to form your own visual representations of options.
     * @return selection in the type it was given as an option
     */
    public static <T> T ask(String question, T[] options, Function<T[], String[]> visualRepresentation) {
        System.out.println(question);
        String[] vr = visualRepresentation.apply(options);
        
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d > %s\n", i + 1, vr[i]);
        }
        
        return options[sc.nextInt() - 1];
    }
    
    /**
     * Returns the option user selected.
     * @param <T> type
     * @param question to lead the user to select an appropriate option.
     * @param options user can select.
     * @param visualRepresentation You may set your visual representations with a pre-defined array of your choice. Make sure its length and ordering matches with the options parameter.
     * @return selection in the type it was given as an option
     */
    public static <T, VR> T ask(String question, T[] options, VR[] visualRepresentation) {
        System.out.println(question);
        
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d > %s\n", i + 1, visualRepresentation[i]);
        }
        
        return options[sc.nextInt() - 1];
    }
    
    /**
     * Program pausing input prompt.
     * @param <T> type
     * @param question to lead the user to select an appropriate option.
     */
    public static void await(String question) {
    	System.out.println(question);
    	sc.nextLine();
    }
    
    /**
     * Program pausing input prompt. Informs the user with this text: "Please enter any key to resume."
     * @param <T> type
     */
    public static void await() {
    	System.out.println("Please enter any key to resume.");
    	resetScanner();
    	sc.nextLine();
    }

    // Misc

    /**
     * Resets the scanner by reinitializing the class to avoid buffer issues.
     */
    public static void resetScanner() {
        new Input();
    }
    
    public static Scanner scanner() {
        return sc;
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

    /**
     * Gets user input as a line and it is empty ("") safe
     * @return
     */
    public static String getLineEmptySafe(String ask) {
        System.out.print(ask + " ");
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
    
    public class VisualRepresentation {
        public static Function<Object[], String[]> applyToStringToList = (options) -> {
            String[] arr = new String[options.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = options[i].toString();
            }
            return arr;
        };
    }
}

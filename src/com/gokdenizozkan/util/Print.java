package com.gokdenizozkan.util;

public class Print <T> extends Object {
	
    public static <T> void array(T[] arr) {
        for (T e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    // PRINT LINE
    public static <T> void line(T toPrint) {
        System.out.print(toPrint);
    }

    public static <T> void line(T toPrint, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.print(toPrint);
        }
    }
    
    // PRINT LINE WITH NEWLINE AT THE END
    public static void nline() {
        System.out.println();
    }
    
    public static <T> void nline(T toPrint) {
        System.out.println(toPrint);
    }

    public static <T> void nline(T toPrint, int amount) {
        for (int t = 0; t < amount; t++) {
            System.out.println(toPrint);
        }
    }

    // PRINT FORMATTED LINE
    public static void fline(String str, Object... formatting) {
        System.out.printf(str, formatting);
    }

    public static void fline(int amount, String str, Object... formatting) {
        for (int t = 0; t < amount; t++) {
            System.out.printf(str, formatting);
        }
    }

    // PRINT FORMATTED LINE WITH NEWLINE AT THE END
    public static void nfline(String str, Object... formatting) {
        System.out.printf(str + "\n", formatting);
    }

    public static void nfline(int amount, String str, Object... formatting) {
        for (int t = 0; t < amount; t++) {
            System.out.printf(str + "\n", formatting);
        }
    }


    // MISC
    public static void title(String title) {
    	lineOfChar('#', title.length() * 3, 2);
        
        lineOfChar(' ', title.length(), 0);
        System.out.println(title.toUpperCase());
        System.out.println();

        lineOfChar('#', title.length() * 3, 2);
    }
    
    /**
     * Prints a line of characters of your choice. As default, prints a new line after line is printed out. You can change this behavior by explicitly giving the amount of newlines as the last argument.
     * @param c character to form the line.
     * @param length of the line.
     * @param amountOfNewlines you want to print.
     */
    public static void lineOfChar(char c, int length, Integer... amountOfNewlines) {
    	for (int i = 0; i < length; i++) {
    		System.out.print(c);
    	}
    	if (amountOfNewlines.length != 0) {
    		for (int i = 0; i < amountOfNewlines[0]; i++) {
    			System.out.println();
    		}
    	}
    	else System.out.println();
    }
}

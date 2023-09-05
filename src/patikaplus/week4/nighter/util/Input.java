package patikaplus.week4.nighter.util;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static int getSelection() {
        return sc.nextInt();
    }

    public static String getLine() {
        return sc.nextLine();
    }
}

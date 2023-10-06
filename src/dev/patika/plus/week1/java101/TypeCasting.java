package dev.patika.plus.week1.java101;

import java.util.Scanner;

public class TypeCasting {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        int inInt;
        float inFloat;
        System.out.println("Enter a whole number:");
        inInt = sc.nextInt();
        System.out.println((float) inInt);

        System.out.println("Enter a float number:");
        inFloat = sc.nextFloat();
        System.out.println((int) inFloat);
    }
}

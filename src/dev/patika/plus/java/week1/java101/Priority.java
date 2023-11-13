package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class Priority {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        int a, b, c;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();


        System.out.printf("%d + %d * %d - %d", a, b, c, b);
        System.out.println("\nResult of the arithmetic operation above is " + ((a + (b * c)) - b));
    }
}

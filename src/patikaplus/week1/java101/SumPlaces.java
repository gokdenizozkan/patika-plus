package patikaplus.week1.java101;

import java.util.Scanner;

public class SumPlaces {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        int in, sum = 0;

        System.out.println("Please enter a number to sum its all places:");
        in = sc.nextInt();

        while (in != 0) {
            sum += (in % 10);
            in /= 10;
        }

        System.out.println(sum);
    }
}

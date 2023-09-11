package patikaplus.week1.java101;

import java.util.Scanner;

public class SumPreviousAttemptMod24 {
    private static final Scanner sc = new Scanner(System.in);
    private static int sum = 0;

    public static void run() {
        while (true) {
            // input
            int in = sc.nextInt();

            if (!(in % 2 == 0)) break;
            else if (in % 4 == 0) sum += in;
        }
        System.out.println(sum);
    }
}

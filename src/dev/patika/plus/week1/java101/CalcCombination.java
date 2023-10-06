package dev.patika.plus.week1.java101;

import java.util.Scanner;

public class CalcCombination {
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        long[] set;
        long subsetMemberAmount;

        System.out.println("Please enter the member amount for your set:");
        set = new long[sc.nextInt()];

        System.out.println("Please enter the member amount of your subset:");
        subsetMemberAmount = sc.nextInt();

        System.out.println(calcComb(set, subsetMemberAmount));
    }

    private static long calcComb(long[] set, long subsetMemberAmount) {
        return factorial(set.length) / (
                factorial(subsetMemberAmount) * factorial((set.length - subsetMemberAmount)));
    }

    private static long factorial(long num) {
        long f = num;
        for (int i = 1; i < num; i++) {
            f *= i;
        }
        return f;
    }
}

package patikaplus.week1;

import java.util.Scanner;

public class PerfectNumberFinder {
    public static void run() {
        Scanner input = new Scanner(System.in);
        long number, sumOfFactors = 0;
        System.out.println("Please enter your number to see if it is a perfect number:");
        number = input.nextLong();

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sumOfFactors += i;
            }
        }

        System.out.println(number + " is a " + (sumOfFactors == number ? "perfect number!" : "normal number."));
        input.close();
    }
}

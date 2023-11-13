package dev.patika.plus.java.week2;

import java.util.Scanner;

public class PrimeNumberFinder {
    public static void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a number (bigger than 1) to see if it is prime:");
        int number = sc.nextInt();

        System.out.println(number + " is a " + (isPrime(number) ? "PRIME number!" : "normal number."));
    }

    public static boolean isPrime(int... number) {
        /*
         A recursive method. Makes sure the divider is not equal to anything below than 2.
         It takes the number and performs a modulo operation with the digit at ones place of the number.
         Performs it for 10 times, for all digits, 0 to 9 (including).
         0 and 1s are skipped. If any of the remaining digits' modulo equals 0 (except for the number itself), isPrime method returns false.
        */
        int num = number[0];
        if (num < 2) return false;

        int attempt = number.length == 1 ? 0 : number[1];
        int divider = (num - attempt) % 10;

        if (divider < 2) {
            if (attempt == 10) return true;
            return isPrime(num, ++attempt);
        }

        int division = num % divider;

        if (division == 0) {
            if (num > 9) return false;
            if (num < 10 && num != divider) return false;
        }

        if (attempt == 10) return true;
        return isPrime(num, ++attempt);
    }
}

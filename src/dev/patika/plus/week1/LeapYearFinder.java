package dev.patika.plus.week1;

import java.util.Scanner;

public class LeapYearFinder {
    public static void run() {
        int year;
        boolean leapYear = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a year to check if it is a leap year:");
        year = input.nextInt();
        input.close();

        if (isModZero(year, 100)) {
            if (isModZero(year, 400)) leapYear = true;
        }
        else {
            if (isModZero(year, 4)) leapYear = true;
        }

        System.out.println("Year " + year + " is a " + (leapYear ? "leap year!" : "normal year."));
    }

    public static boolean isModZero(int number, int mod) {
        return number % mod == 0;
    }
}

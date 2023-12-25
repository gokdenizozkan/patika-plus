package dev.patika.plus.java.week1.java101;

import java.util.Scanner;


public class RecommendActivity {
    static Scanner sc = new Scanner(System.in);
    static String activity;
    static int temperature;


    // Call this method from App to run the program
    // You may need to import this file first
    public static void run() {
        System.out.println("Please enter the temperature:");
        temperature = sc.nextInt();

        if (temperature < 5) activity = "skiing";
        else if (temperature < 15) activity = "to film";
        else if (temperature < 25) activity = "to picnic";
        else activity = "swimming";

        System.out.println("Go " + activity);
    }
}

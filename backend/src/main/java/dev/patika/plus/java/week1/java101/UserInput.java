package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class UserInput {
    // Call this method from App to run the program
    // You may need to import this file first
    static Scanner sc = new Scanner(System.in);
    static String username, password, input;

    public static void run() {
        System.out.println("Welcome!");
        System.out.println("Please enter the type of action you want:\n1 -> Register : 2 -> Log in");
        input = sc.nextLine();

        if (input.equals("1")) {
            register();
        }
        if (input.equals("2")) {
            login();
        }
        else {
            System.out.println("Your input was not correct, restarting the program.");
            run();
        }
    }

    private static void register() {
        System.out.println("\n\nThis system can hold only one account.\nIf you have an account already, its credentials will be overwritten.\n");
        System.out.println("Please enter your username:");
        username = sc.nextLine();

        System.out.println("Please enter your password:");
        password = sc.nextLine();

        System.out.println("Your account is successfully created.\nYou are being forwarded to login screen, please wait.");
        login();
    }

    private static void login() {
        System.out.println("\n\nPlease enter your credentials to log in...");

        System.out.println("Username:");
        input = sc.nextLine();

        if (!(input.equals(username))) { // if the given username does not equal the username
            System.out.println("User not found. Please create an account first.\nYou are being forwarded to register screen.");
            register();
            return; // Program should not continue from where it left off.
        }

        System.out.println("Password:");
        input = sc.nextLine();

        if (!(input.equals(password))) {
            System.out.println("Your password is incorrect.\nWould you like to reset your password? (Y/N)");
            input = sc.nextLine();

            if (input.equals("Y")) {
                resetPassword();
                return;
            }
            else {
                System.out.println("Login was not successful. Exiting the program.");
                return;
            }
        }
        // If logged in successfully
        System.out.println("\n\nWelcome " + username + "!" + "\nYou successfully logged in.");
    }

    private static void resetPassword() {
        System.out.println("\n\nYour new password should be different than the previous one.");

        System.out.println("Please enter your new password for " + username + ":");
        input = sc.nextLine();

        if (input.equals(password)) {
            resetPassword();
        }
        else {
            password = input;
            System.out.println("Your new password is set. You are being forwarded to log in screen." );
            login();
        }
    }
}

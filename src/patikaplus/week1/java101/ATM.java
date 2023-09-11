package patikaplus.week1.java101;

import java.util.Scanner;

public class ATM {
    private static Scanner sc;
    private static String username;
    private static String password;
    private static double balance;
    private static int trialsLeft;

    static {
        sc = new Scanner(System.in);
        balance = 0;
        trialsLeft = 3;
    }

    public static void run() {
        System.out.println(); // print blank line for readability
        if (login()) start();
        else {
            if (trialsLeft == 0) {
                System.out.println("You entered your credentials invalid for three times.\nYour account is blocked.\nPlease contact with your bank.");
            } else {
                System.out.println("The credentials you entered were invalid. Please try again.\n" + trialsLeft + " trials left.");
                run();
            }
        }
    }

    private static void start() {
        printMenu();
        Operation operation = Operation.getValue(sc.nextInt());

        switch (operation) {
            case DEPOSIT -> deposit();
            case WITHDRAW -> withdraw();
            case BALANCE -> System.out.println("Your balance is " + balance);
            case LOGOUT -> {
                System.out.println("Logging out of your account...\nHave a pleasant day!");
                run();
                return;
            }
            case EXITPROGRAM -> {
                return;
            }
        }

        System.out.println("\nReturning to menu.\n");
        start();
    }

    private static void withdraw() {
        System.out.println("Please enter the amount you want to withdraw:");
        balance -= sc.nextDouble();

        System.out.println("Your new balance is " + balance);
    }

    private static void deposit() {
        System.out.println("Please enter the amount you want to deposit:");
        balance += sc.nextDouble();

        System.out.println("Your new balance is " + balance);
    }

    private static void printMenu() {
        for (int i = 0; i < Operation.length; i++) {
            System.out.print(i + " " + Operation.getValueAsString(i));
            System.out.println();
        }
    }

    private static boolean login() {
        // Returns if login was successful
        clearScBuffer();

        String u, p;
        ask("Username:");
        u = sc.nextLine();

        ask("Password:");
        p = sc.nextLine();

        if (username == null) register(u, p);
        return checkCredentials(u, p);
    }

    private static void register(String username, String password) {
        ATM.username = username;
        ATM.password = password;
    }

    private static boolean checkCredentials(String username, String password) {
        boolean correct = (ATM.username.equals(username) && ATM.password.equals(password));
        if (!correct) trialsLeft--;
        return correct;
    }

    private static void ask(String text) {
        System.out.println(text);
    }

    private static void clearScBuffer() {
        sc = new Scanner(System.in);
    }

    enum Operation {
        DEPOSIT, WITHDRAW, BALANCE, LOGOUT, EXITPROGRAM;

        public static Operation[] values;
        public static int length;

        static {
            Operation.values = values(); // values() is an expensive call, thus I call it once
            Operation.length = values.length;
        }

        public static Operation getValue(int index) {
            return values[index];
        }

        public static String getValueAsString(int index) {
            return values[index].name();
        }
    }
}

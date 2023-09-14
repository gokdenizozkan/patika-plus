package patikaplus.week2;

import patikaplus.util.Input;
import patikaplus.util.Print;
import patikaplus.util.Tengri;

public class NumberGuessing {
    public static void main(String[] args) {
        int num = Tengri.range(100);
        int maxAttempts = 5;
        int attempts = 0;
        int triesLeft = maxAttempts;
        boolean guessed = false;

        while (attempts < maxAttempts) {
            int in = Input.getInt("Your guess:");
            attempts++;

            if (in == num) {
                guessed = true;
                break;
            }

            triesLeft = maxAttempts - attempts;
            if (triesLeft == 0) break;
            if (in < num) Print.line("Secret number is higher than your input.", 1);
            else Print.line("Try a lower number.", 1);
            System.out.printf("You have %d %s left!\n" , triesLeft, triesLeft == 1 ? "try" : "tries");
        }

        // Check if the user won or lost
        if (guessed) Print.line("YOU WIN! Secret number was really " + num, 1);
        else Print.line("OPS! You are out of tries. Maybe next time...\nSecret number was " + num, 1);
    }
}

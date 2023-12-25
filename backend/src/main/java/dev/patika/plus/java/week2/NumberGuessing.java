package dev.patika.plus.java.week2;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Print;
import com.gokdenizozkan.util.Tengri;

public class NumberGuessing {
    public static void main(String[] args) {
        int num = Tengri.range(100);
        int triesLeft = 5;
        boolean guessed = false;

        while (triesLeft > 0) {
            Print.fline("You have %d %s left!" , triesLeft, triesLeft == 1 ? "try" : "tries");
            int in = Input.getInt("\nYour guess:");

            if (in == num) {
                guessed = true;
                break;
            }

            if (in < num) Print.nline("Secret number is higher than your input.");
            else Print.nline("Try a lower number.");

            triesLeft--;
        }

        // Check if the user won or lost
        if (guessed) Print.nline("YOU WIN! Secret number was really " + num);
        else Print.nline("OPS! You are out of tries. Maybe next time...\nSecret number was " + num);
    }
}

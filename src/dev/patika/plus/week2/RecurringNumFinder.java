package dev.patika.plus.week2;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Print;
import com.gokdenizozkan.util.Parse;

import java.util.ArrayList;

public class RecurringNumFinder {
    public static void run() {
        int[] ins = Parse.toArrayInt(Input.getLine(' ', "Please enter your data set separated with spaces:\n(10 50 200 90)"));
        ArrayList<Integer> recurs = new ArrayList<>();

        for (int i : ins) {
            if (recurs.contains(i)) {
                Print.line(i, 1);
                Print.line(" ", 1);
            }
            recurs.add(i);
        }
    }
}

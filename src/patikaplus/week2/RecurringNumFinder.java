package patikaplus.week2;

import patikaplus.util.Input;
import patikaplus.util.Parse;
import patikaplus.util.Print;

import java.util.ArrayList;

public class RecurringNumFinder {
    public static void run() {
        System.out.println("Please enter your data set separated with spaces:\n(10 50 200 90)");
        int[] ins = Parse.toArrayInt(Input.getInputsBySpace());
        ArrayList<Integer> recurs = new ArrayList<>();

        for (int i : ins) {
            if (recurs.contains(i)) {
                Print.num(i, 1);
                Print.line(" ", 1);
            }
            recurs.add(i);
        }
    }
}

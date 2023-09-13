package patikaplus.week2;

import patikaplus.util.Array;
import patikaplus.util.Input;

public class IsPalindrome {
    public static void main(String[] args) {
        String in = Input.getLine("Please enter a word:");
        String reversed = Array.reverse(in);

        if (in.equals(reversed)) {
            System.out.println("It is Palindrome! >.<");
        }
        else {
            System.out.println("It is not palindrome... :(");
        }
    }
}

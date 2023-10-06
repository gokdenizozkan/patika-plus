package dev.patika.plus.week2;

import com.gokdenizozkan.util.Input;

public class PalindromSayiBulucu {
    public static void run() {
        String in = Input.getLine("Bir sayı girin:");

        if (reverse(in).equals(in)) {
            System.out.println("^^ Palindrom sayı! Kimse ters düz edemez. >.<");
        }
        else {
            System.out.println(":( Palindrom sayı değil... tersi düz olmuş. :S");
        }
    }

    private static String reverse(String str) {
        char[] charArr = str.toCharArray();
        int len = charArr.length;

        char[] reversed = new char[len];
        len--; // to make it index
        for (int i = len; i >= 0; i--) {
            reversed[len - i] = charArr[i];
        }
        return String.valueOf(reversed);
    }
}

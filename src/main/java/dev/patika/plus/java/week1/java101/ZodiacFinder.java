package dev.patika.plus.java.week1.java101;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZodiacFinder {
    private static Scanner sc;
    private static String[] in; // input
    private static String day;
    private static String month;
    private static int date; //mmDD
    private static Map<int[], String> zodiacs; // values of int[] are structured as following => MMDD => 1201, 1030
    private static String zodiac;

    static {
        sc = new Scanner(System.in);
        in = new String[2];

        zodiacs = new HashMap<>();
        zodiacs.put(initRange(122, 219), "Aquarius");
        zodiacs.put(initRange(220, 320), "Pisces");
        zodiacs.put(initRange(321, 420), "Aries");
        zodiacs.put(initRange(421, 521), "Taurus");
        zodiacs.put(initRange(522, 622), "Gemini");
        zodiacs.put(initRange(623, 722), "Cancer");
        zodiacs.put(initRange(723, 822), "Leo");
        zodiacs.put(initRange(823, 922), "Virgo");
        zodiacs.put(initRange(923, 1022), "Libra");
        zodiacs.put(initRange(1023, 1121), "Scorpius");
        zodiacs.put(initRange(1122, 1221), "Sagittarius");
        zodiacs.put(initRange(1222, 121), "Capricornus");
    }

    // Run this method from App method, you may need to import it first <- follow the package name written at top
    public static void run() {
        initDate();
        System.out.println(date);

        for (int[] range : zodiacs.keySet()) {
            if (date >= range[0] && date <= range[1]) {
                zodiac = zodiacs.get(range);
            }
        }

        System.out.println("Your zodiac is " + zodiac);
    }

    private static int[] initRange(int beg, int end) {
        return new int[]{beg, end};
    }

    private static void initDate() {
        System.out.println("Please write your birth date as following: 01/12\n[DD]/[MM]");
        in = sc.nextLine().trim().split("/");

        day = in[0];
        month = in[1];

        date = Integer.parseInt(month + day);
    }
}
package dev.patika.plus.java.week1.java101;

import java.util.Scanner;

public class CourseGradeCalc {
    static Scanner sc  = new Scanner(System.in);
    static String[] courses = {"Physics", "Math", "Turkish", "Chem", "Music"};
    static int courseCount = courses.length;
    static float grade;

    // Call this method from App to run the program
    // You may need to import this file first
    public static void run() {
        float avg = 0.0f;

        System.out.println("Please enter your grades:");
        for (int c = 0; c < courseCount; c++) {
            System.out.println(courses[c] + " grade:");
            grade = sc.nextFloat();

            if (grade < 0 || grade > 100) {
                continue;
            }
            avg += grade;
        }
        avg /= courseCount;

        System.out.println("To pass, your average of grades should be equal or bigger than 55.\nYour avg. grade is " + avg);
        System.out.println(avg >= 55 ? "You have passed! ^^": "You could not make it. :(");
    }
}

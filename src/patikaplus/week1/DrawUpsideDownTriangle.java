package patikaplus.week1;

import java.util.Scanner;

public class DrawUpsideDownTriangle {
    public static void run() {
        Scanner input = new Scanner(System.in);
        int baseLenght, starCount;

        System.out.println("How many stars should the base lenght of the triangle be?");
        baseLenght = input.nextInt();

        for (int i = 0; i < baseLenght; i++) {
            // Print baseLenght - 2*/loop amount of *
            starCount = baseLenght - (i * 2);
            if (starCount < 1) break;

            for (int j = 0; j < i; j++) {
                System.out.print((" "));
            }

            for (int j = starCount; j > 0; j--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}

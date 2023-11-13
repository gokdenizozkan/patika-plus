package dev.patika.plus.java.week1;

import java.util.Scanner;

public class FibonacciSequencePrinter {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int priorNumber, previousNumber, currentNumber, sequenceLength;

        priorNumber = 0;
        previousNumber = 1;

        System.out.println("Please enter the sequence length:");
        sequenceLength = sc.nextInt();
        for (int i = 0; i < sequenceLength; i++) {
            currentNumber = priorNumber + previousNumber;

            System.out.println(priorNumber + " + " + previousNumber + " = " +  currentNumber);

            priorNumber = previousNumber;
            previousNumber = currentNumber;
        }
    }
}
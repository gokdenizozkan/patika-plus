package dev.patika.plus.java.week1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FlightTicketPriceCalculator {
    public static void runCalculation(boolean discountOnDiscountedPrice) throws Exception {
        printPrice(calculatePrice(getInputs(), discountOnDiscountedPrice));
    }

    public static void printPrice(float price) {
        System.out.println("Total price: " + price);
    }

    public static float calculatePrice(Map<String, Integer> data, Boolean discountOnDiscountedPrice) {
        float TL_KM = 0.1f, price, ageDiscount, flightTypeDiscount;

        // Discounts are summed right away, for getDiscount methods return a negative value.
        price = data.get("distance") * TL_KM * data.get("flightType");
        ageDiscount = getAgeDiscount(price, data.get("age"));
        if (discountOnDiscountedPrice)
            price += ageDiscount; // Apply discount on the discounted price (if it is set to true)
        flightTypeDiscount = getFlightTypeDiscount(price, data.get("flightType"));

        if (discountOnDiscountedPrice) price += flightTypeDiscount;
        else price += ageDiscount + flightTypeDiscount;

        return price;
    }

    public static float getFlightTypeDiscount(float price, int flightType) {
        float discountRate = 0.2f;
        if (flightType == 2) return -(price * discountRate);
        else return 0;
    }

    public static float getAgeDiscount(float price, int age) {
        Map<String, Integer> discountAges = new HashMap<>(); // values are used with less than
        Map<String, Float> discountRates = new HashMap<>();
        float discountAmount;

        discountAges.put("child", 12); // <12
        discountAges.put("young", 25); // 12-24
        discountAges.put("adult", 65); // 25-64, if > 64 => elderly

        discountRates.put("child", 0.5f);
        discountRates.put("young", 0.1f);
        discountRates.put("adult", 0.0f);
        discountRates.put("elderly", 0.3f);

        // Apply discounts
        if (age < discountAges.get("child")) discountAmount = -(price * discountRates.get("child"));
        else if (age < discountAges.get("young")) discountAmount = -(price * discountRates.get("young"));
        else if (age < discountAges.get("adult")) discountAmount = -(price * discountRates.get("adult"));
        else discountAmount = -(price * discountRates.get("elderly"));

        return discountAmount;
    }

    public static boolean isInputValidInt(int input, String checkCase) throws Exception {
        return switch (checkCase) {
            case "isNegative" -> input < 0;
            case "isNotOneOrTwo" -> !(input == 1 || input == 2);
            default -> throw new Exception("Arg 'checkCase' for isInputCorrectInt was not found or valid.");
        };
    }

    public static Map<String, Integer> getInputs() throws Exception {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> data = new HashMap<>();
        int distance, age, flightType;
        Exception invalidInput = new Exception("Your input was invalid or had typos. Please try again.\n!!! All inputs should be whole numbers !!!\n!!! Distance and age cannot be negative !!!\n!!! Flight type should only be typed as one digit !!!");

        try {
            System.out.println("Please enter the distance (km):");
            distance = input.nextInt();
            if (isInputValidInt(distance, "isNegative")) throw invalidInput;

            System.out.println("Please enter your age:");
            age = input.nextInt();
            if (isInputValidInt(age, "isNegative")) throw invalidInput;

            System.out.println("Will you buy your return tickets now (20% off!):\n1 => One Way, 2 => Two Way");
            flightType = input.nextInt();
            if (isInputValidInt(flightType, "isNotOneOrTwo")) throw invalidInput;

            data.put("distance", distance);
            data.put("age", age);
            data.put("flightType", flightType);
            return data;
        } catch (InputMismatchException e) {
            throw invalidInput;
        }
    }
}
package patikaplus.util;

public class Bundles {
    public static int[] getInputsAsInt() {
        System.out.println("Please enter your data set separated by spaces:");
        return Parse.toArrayInt(Input.getInputsBySpace());
    }
}

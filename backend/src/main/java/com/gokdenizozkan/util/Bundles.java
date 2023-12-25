package com.gokdenizozkan.util;

public class Bundles {
    public static int[] getInputsAsInt(char separator, String ask) {
        return Parse.toArrayInt(Input.getLine(separator, ask));
    }
    public static Integer[] getInputsAsInteger(char separator, String ask) {
        return Parse.toArrayInteger(Input.getLine(separator, ask));
    }
}

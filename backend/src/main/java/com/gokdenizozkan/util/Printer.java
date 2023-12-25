package com.gokdenizozkan.util;

public class Printer {
    private String format;
    private boolean newline;
    
    public Printer() {
        this.format = "";
        this.newline = false;
    }
    
    public void print(Object... toPrint) {
        String printee = String.format(this.format, toPrint);
        printee = newline ? printee + "\n" : printee;
    }
    
    public Printer withNewline() {
        this.newline = true;
        return this;
    }
    
    public Printer withFormatting(String format) {
        this.format = format;
        return this;
    }
    
    
}

package dev.patika.plus.java.week5.PatikaStore.products;

import dev.patika.plus.java.week5.PatikaStore.Brand;
import dev.patika.plus.java.week5.PatikaStore.Product;

public class Smartphone extends Product {
    private int memory;
    private float screenSize;
    private int battery;
    private int ram;
    private Color color;
    
    public Smartphone(Brand brand, String name, int unitPrice, int stockAmount, float discountRate, int memory, float screenSize, int battery, int ram, Color color) {
        super(brand, name, unitPrice, stockAmount, discountRate);
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }
    
    public static String getBodyFormat() {
        String bodyFormat = """
                 %-5d | %-10f | %-5d | %-5d | %-10s |
                """;
        return Product.bodyFormat + bodyFormat;
    }

    public static String getHeaderFormat() {
        String headerFormat = " %-5s | %-10s | %-5s | %-5s | %-10s |";
        return Product.headerFormat + headerFormat;
    }

    public static String[] getHeader() {
        String[] fundamental = Product.getHeader();
        String[] header = new String[] {"MEMORY", "SCREEN SIZE", "BATTERY", "RAM", "COLOR"};
        
        String[] data = new String[fundamental.length + header.length];
        System.arraycopy(fundamental, 0, data, 0, fundamental.length);
        System.arraycopy(header, 0, data, fundamental.length, header.length);
        return data;
    }
    
    @Override
    public Object[] getAllData() {
        Object[] fundamental = super.getAllData();
        Object[] data = new Object[] {
                this.memory, this.screenSize, this.battery, this.ram, this.color.toString()
        };
        
        Object[] dataAll = new Object[fundamental.length + data.length];
        System.arraycopy(fundamental, 0, dataAll, 0, fundamental.length);
        System.arraycopy(data, 0, dataAll, fundamental.length, data.length);
        return dataAll;
    }
    
    public enum Color {
        BLACK, RED, BLUE;
    }
}
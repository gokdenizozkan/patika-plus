package dev.patika.plus.week5.PatikaStore.products;

import java.util.ArrayList;

import dev.patika.plus.week5.PatikaStore.Brand;
import dev.patika.plus.week5.PatikaStore.Product;

public class Laptop extends Product {
    private int storage;
    private int ram;
    private float screenSize;
    
    public Laptop(ArrayList<Object> params) {
        super(params.subList(0, 5));
        this.storage = (Integer) params.get(5);
        this.ram = (Integer) params.get(6);
        this.screenSize = (Float) params.get(7);
    }
    
    public Laptop(Brand brand, String name, int unitPrice, int stockAmount, float discountRate, int storage, int ram, float screenSize) {
        super(brand, name, unitPrice, stockAmount, discountRate);
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public static String getBodyFormat() {
        String bodyFormat = """
                | %-10d | %-5d | %-10f |
                """;
        return Product.bodyFormat + bodyFormat;
    }
    
    public static String getHeaderFormat() {
        String headerFormat = "| %-10s | %-5s | %-10s |";
        return Product.headerFormat + headerFormat;
    }
    
    public static String[] getHeader() {
        return new String[] {"STORAGE", "RAM", "SCREEN SIZE"};
    }
    
    @Override
    public Object[] getAllData() {
        Object[] fundamental = super.getAllData();
        Object[] data = new Object[] {
                this.storage, this.ram, this.screenSize
        };
        
        Object[] dataAll = new Object[fundamental.length + data.length];
        System.arraycopy(fundamental, 0, dataAll, 0, fundamental.length);
        System.arraycopy(data, 0, dataAll, fundamental.length, data.length);
        return dataAll;
    }
}
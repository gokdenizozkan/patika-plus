package patikaplus.week5.PatikaStore.products;

import patikaplus.week5.PatikaStore.Brand;
import patikaplus.week5.PatikaStore.Product;

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
    
    public enum Color {
        BLACK, RED, BLUE;
    }    
}
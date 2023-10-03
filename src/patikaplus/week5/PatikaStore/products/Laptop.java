package patikaplus.week5.PatikaStore.products;

import java.util.ArrayList;

import patikaplus.week5.PatikaStore.Brand;
import patikaplus.week5.PatikaStore.Product;

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
}
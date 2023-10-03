package patikaplus.week5.PatikaStore;

import java.util.ArrayList;
import java.util.List;

import patikaplus.week5.PatikaStore.products.Laptop;
import patikaplus.week5.PatikaStore.products.Smartphone;

public abstract class Product {
    private final int id;
    private static int assignId = 0;
    
    private Brand brand;
    private String name;
    private int unitPrice;
    private int stockAmount;
    private float discountRate;
    
    private static ArrayList<Product> productees = new ArrayList<>();
    private static ArrayList<String> producables = new ArrayList<>();
    
    static {
        producables.add(Smartphone.class.getSimpleName());
        producables.add(Laptop.class.getSimpleName());
    }
    
    protected Product(Brand brand, String name, int unitPrice, int stockAmount, float discountRate) {
        this.brand = brand;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockAmount = stockAmount;
        this.discountRate = discountRate;
        
        this.id = assignId++;
        productees.add(this);
    }

    public Product(List<Object> list) {
        this.brand = (Brand) list.get(0);
        this.name = (String) list.get(1);
        this.unitPrice = (Integer) list.get(2);
        this.stockAmount = (Integer) list.get(3);
        this.discountRate = (Float) list.get(4);
        
        this.id = assignId++;
        productees.add(this);
    }
    
    public static void delete(int id) {
        for (Product b : productees) {
            if (b.getId() == id) {
                productees.remove(b);
                return;
            }
        }
    }

    public static ArrayList<Product> getProductees() {
        return productees;
    }
    
    public static ArrayList<String> getProducables() {
        return producables;
    }
    
    public int getId() {
        return id;
    }
    
    protected enum Type {
        LAPTOP(Laptop.class), SMARTPHONE(Smartphone.class);
        
        Class<?> type;
        
        private Type(Class<?> cl) {
            this.type = cl;
        }
        
        public Class<?> getType() {
            return type;
        }
    }
}
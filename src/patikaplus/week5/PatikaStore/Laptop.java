package patikaplus.week5.PatikaStore;

public class Laptop extends Product {
    private int storage;
    private int ram;
    private float screenSize;
    
    protected Laptop(Brand brand, String name, int unitPrice, int stockAmount, float discountRate, int storage, int ram, float screenSize) {
        super(brand, name, unitPrice, stockAmount, discountRate);
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
    }
}
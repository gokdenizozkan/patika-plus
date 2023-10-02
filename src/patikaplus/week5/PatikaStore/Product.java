protected abstract class Product {
    private int id;
    private static int assignId = 0;
    
    private Brand brand;
    private String name;
    private int unitPrice;
    private int stockAmount;
    private float discountRate;
    
    protected Product(Brand brand, String name, int unitPrice, int stockAmount, float discountRate) {
        this.brand = brand;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stockAmount = stockAmount;
        this.discountRate = discountRate;
        
        this.id = assignId++;
    }
}
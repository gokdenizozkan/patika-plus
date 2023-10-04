package patikaplus.week5.PatikaStore;

import java.util.ArrayList;
import java.util.List;

import patikaplus.week5.PatikaStore.products.Laptop;
import patikaplus.week5.PatikaStore.products.Smartphone;

public abstract class Product implements Comparable<Product> {
    private final int id;
    private static int assignId = 0;
    private static boolean sortWithId = true;
    
    private Brand brand;
    private String name;
    private int unitPrice;
    private int stockAmount;
    private float discountRate;
    
    private static ArrayList<Product> productees = new ArrayList<>();
    private static ArrayList<String> producables = new ArrayList<>();
    
    protected static String[] header = {"ID", "PRODUCT NAME", "PRICE", "BRAND"};
    protected static String headerFormat = "| %-2s | %-30s | %-10s | %-15s |";
    protected static String bodyFormat = """
            | %-2d | %-30s | %-10d | %-15s |""";
    
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
    
    public static ArrayList<String> getAvailableProducteeTypes() {
        ArrayList<String> availables = new ArrayList<>();
        for (Product p : productees) {
            String type = p.getClass().getSimpleName();
            if (producables.contains(type) && !availables.contains(type)) {
                availables.add(p.getClass().getSimpleName());
            }
        }
        return availables;
    }
    
    public static ArrayList<Product> getProducteesOfType(String type) {
        ArrayList<Product> producteesOfType = new ArrayList<>();
        for (Product p : productees) {
            if (p.getClass().getSimpleName() == type) {  
                producteesOfType.add(p);
            }
        }
        return producteesOfType;
    }

    @Override
    public int compareTo(Product o) {
        int thisId = this.id;
        int otherId = o.getId();
        
        String thisName = this.name.toLowerCase();
        String otherName = o.getName().toLowerCase();
        
        if (sortWithId) {
            if (thisId > otherId) return 1;
            if (thisId < otherId) return -1;
            return 0;
        }
        else {
            int minLen = com.gokdenizozkan.util.Math.min(thisName.length(), otherName.length());
            
            for (int i = 0; i < minLen; i++) {
                if (thisName.charAt(i) > otherName.charAt(i)) return 1;
                if (thisName.charAt(i) < otherName.charAt(i))  return -1;
            }
            return 0;
        }   
    }

    public static ArrayList<Product> filterListByBrand(ArrayList<Product> listToFilter, Brand brand) {
        ArrayList<Product> filtered = new ArrayList<>();
        for (Product p : listToFilter) {
            if (p.getBrand() == brand) {
                filtered.add(p);
            }
        }
        return filtered;
    }
    
    public static ArrayList<Product> getProducteesSorted() {
        productees.sort(null);
        return productees;
    }
    
    public static ArrayList<Product> getProductees() {
        return productees;
    }
    
    public static ArrayList<String> getProducables() {
        return producables;
    }
    
    public static String getHeaderFormat() {
        return headerFormat;
    }
    
    public static String getBodyFormat() {
        return bodyFormat;
    }
    
    public static String[] getHeader() {
        return header;
    }
    
    public Object[] getAllData() {
        return new Object[] {
                this.getId(), this.getName(), this.getUnitPrice(), this.getBrand().getName()
        };
    }    
    
    public int getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public static void setSortWithId(boolean sortWithId) {
        Product.sortWithId = sortWithId;
    }
    
}
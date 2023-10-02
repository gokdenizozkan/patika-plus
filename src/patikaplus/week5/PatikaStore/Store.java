package patikaplus.week5.PatikaStore;

public class Store {
    Priority<Brand> brands;
    
    static {
        brands = new ArrayList<>(new Brand[]{
            new Brand("Samsung"), new Brand("Lenovo"), new Brand("Apple"),
            new Brand("Huawei"), new Brand("Casper"), new Brand("Asus"),
            new Brand("HP"), new Brand("Xiaomi"), new Brand("Huawei")});
    }
}
package dev.patika.plus.week5.PatikaStore;

import dev.patika.plus.week5.PatikaStore.products.Laptop;
import dev.patika.plus.week5.PatikaStore.products.Smartphone;

public class Main {

    public static void main(String[] args) {
        Store s = new Store();
        s.addDefaultBrands();
        
        new Smartphone(Brand.getBrands().get(0), "smartphone 1", 0, 0, 0, 0, 0, 0, 0, Smartphone.Color.BLACK);
        new Smartphone(Brand.getBrands().get(4), "smartphone 2", 0, 0, 0, 0, 0, 0, 0, Smartphone.Color.RED);
        new Smartphone(Brand.getBrands().get(3), "smartphone 3", 0, 0, 0, 0, 0, 0, 0, Smartphone.Color.BLACK);
        new Smartphone(Brand.getBrands().get(2), "smartphone 4", 0, 0, 0, 0, 0, 0, 0, Smartphone.Color.BLUE);
        new Smartphone(Brand.getBrands().get(1), "smartphone 5", 0, 0, 0, 0, 0, 0, 0, Smartphone.Color.BLACK);
        new Laptop(Brand.getBrands().get(5), "Laptop 1", 1, 2, 3, 4, 5, 6);
        new Laptop(Brand.getBrands().get(5), "Laptop 2", 1, 2, 3, 4, 5, 6);
        new Laptop(Brand.getBrands().get(5), "Laptop 3", 1, 2, 3, 4, 5, 6);
        new Laptop(Brand.getBrands().get(5), "Laptop 4", 1, 2, 3, 4, 5, 6);
        new Laptop(Brand.getBrands().get(5), "Laptop 5", 1, 2, 3, 4, 5, 6);
        new Laptop(Brand.getBrands().get(5), "Laptop 61", 1, 2, 3, 4, 5, 6);
        s.mainMenu();
    }
}
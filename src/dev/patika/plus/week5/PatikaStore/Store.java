package dev.patika.plus.week5.PatikaStore;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.ModifyString;
import com.gokdenizozkan.util.Print;

import dev.patika.plus.week5.PatikaStore.products.Laptop;
import dev.patika.plus.week5.PatikaStore.products.Smartphone;

import java.util.ArrayList;
import java.util.function.Function;

public class Store {
    
    // Lambda expression for ask() method
    private static Function<Action[], String[]> visualRepresentation;
    
    static {
        visualRepresentation = (options) -> {
            String[] arr = new String[options.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = options[i].toString();
            }
            return arr;
        };
    }
    
    public void mainMenu() {
        Print.nline("- PATIKA STORE PRODUCT MANAGEMENT PROGRAM -");
        while (true) {
            switch (Input.ask("Please choose the action you want to do:", Action.values(), visualRepresentation)) {
                case LIST_PRODUCTS -> {
                    if (Product.getProductees().isEmpty()) Print.nline("There are no products available in the store.\nYou may create one to list it.\n\nReturning to the main menu.");
                    else listProducts();
                }
                
                case ADD_PRODUCT -> {
                    addProduct();
                }
                
                case DELETE_PRODUCT -> {
                    deleteProduct();
                }
                
                case EXIT -> {
                    return;
                }
            }
            
            Print.nline("");
        }
    }
    
    private void addProduct() {
        //ArrayList<Object> ctor = new ArrayList<Object>();
        Brand arg0 = Brand.selectBrand();
        String arg1 = Input.getLineEmptySafe("Product name:");
        int arg2 = Input.getInt("Price:");
        int arg3 = Input.getInt("Stock amount:");
        float arg4 = Input.getFloat("Discount rate:");
        
        String type = (String) Input.ask("Please enter the product type you want add:", Product.getProducables().toArray());
        switch (type) {
            case "Laptop" -> {
                int arg5 = Input.getInt("Storage:");
                int arg6 = Input.getInt("RAM:");
                float arg7 = Input.getFloat("Screen size:");
                new Laptop(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
            }
            
            case "Smartphone" -> {
                int arg5 = Input.getInt("Memory:");
                float arg6 = Input.getFloat("Screen size:");
                int arg7 = Input.getInt("Battery:");
                int arg8 = Input.getInt("RAM:");
                Smartphone.Color arg9 = Input.ask("Color:", Smartphone.Color.values());
                new Smartphone(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
            }
        }
    }
    
    private void deleteProduct() {
        Product.delete(Input.getInt("Please enter the ID of the product you want to delete:"));
    }
    
    private void listProducts() {
        ArrayList<Product> producteesToList = new ArrayList<>();
        String type = (String) Input.ask("Choose the product type you want to list:", Product.getAvailableProducteeTypes().toArray());
        producteesToList = Product.getProducteesOfType(type);
        
        switch (Input.ask("How to list?", new String[]{"List all", "List and sort by ID", "List and sort by Brand", "List and filter by Brand", "Return to main menu"})) {
            case "List all" -> {
                printProducts(producteesToList, type);
            }
            
            case "List and sort by ID" -> {
                Product.setSortWithId(true);
                producteesToList.sort(null);
                printProducts(producteesToList, type);
            }
            
            case "List and sort by Brand" -> {
                Product.setSortWithId(false);
                producteesToList.sort(null);
                printProducts(producteesToList, type);
            }
            
            case "List and filter by Brand" -> {
                Brand filteringBrand = (Brand) Input.ask("Choose the brand to filter:", Brand.getBrands().toArray(), Input.VisualRepresentation.applyToStringToList);
                
                producteesToList = Product.filterListByBrand(producteesToList, filteringBrand);
                printProducts(producteesToList, type);
            }
            
            case "Return to main menu" -> {
                return;
            }

        }    
    }
    
    private void printProducts(ArrayList<Product> producteesToPrint, String type) {        
        String headerFormat = "";
        String bodyFormat = "";
        String[] header = null; // values for header
        
        switch (type) {
            case "Smartphone" -> {
                headerFormat = Smartphone.getHeaderFormat();
                bodyFormat = Smartphone.getBodyFormat();
                header = Smartphone.getHeader();
            }
            
            case "Laptop" -> {
                headerFormat = Laptop.getHeaderFormat();
                bodyFormat = Laptop.getBodyFormat();
                header = Laptop.getHeader();
            }
        }
        String headerToPrint = String.format(headerFormat, (Object[]) header);
        Print.nline(headerToPrint);
        Print.lineOfChar('-', headerToPrint.length(), 1);
        
        for (Product p : producteesToPrint) {
            String toPrint = String.format(bodyFormat, p.getAllData());
            Print.line(toPrint);
            Print.lineOfChar('-', toPrint.length());
        }
    }
    
    public void addDefaultBrands() {
        new Brand("Samsung");
        new Brand("Lenovo");
        new Brand("Apple");
        new Brand("Huawei");
        new Brand("Casper");
        new Brand("Asus");
        new Brand("HP");
        new Brand("Xiaomi");
        new Brand("Monster");
    }
    
    private enum Action {
        LIST_PRODUCTS, ADD_PRODUCT, DELETE_PRODUCT, EXIT;
        
        @Override
        public String toString() {
            return ModifyString.capitalize(this.name().replace("_", " "));
        }
    }
}
package patikaplus.week5.PatikaStore;

import java.util.ArrayList;
import java.util.function.Function;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Print;


public class Brand implements Comparable<Brand> {
    private int id;
    private String name;
    private static int idToAssign = 0;
    private static ArrayList<Brand> brands;
    
    static {
        brands = new ArrayList<>();
    }
    
    public Brand(String name) {
        this.name = name;
        this.id = idToAssign++;
        brands.add(this);
        brands.sort(null);
    }
    
    public static Brand selectBrand() {
        Brand selection = (Brand) Input.ask("Select your brand: ", brands.toArray(), Input.VisualRepresentation.applyToStringToList);
        //if (selection == "Register new") return new Brand(Input.getLine("Enter the brand name:"));
        //else return new Brand(selection);
        Print.line(selection.getName());
        return new Brand("uiy");
    }
    
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Brand o) {
        String thisName = this.name;
        String otherName = o.getName();
        int minLen = com.gokdenizozkan.util.Math.min(thisName.length(), otherName.length());
        
        for (int i = 0; i < minLen; i++) {
            if (thisName.charAt(i) > otherName.charAt(i)) return 1;
            if (thisName.charAt(i) < otherName.charAt(i))  return -1;
        }
        return 0;
    }
    
    public static ArrayList<Brand> getBrands() {
        return brands;
    }
    
    @Override
    public String toString() {
        return name;
    }
/*
    @Override
    public int compare(Brand o1, Brand o2) {
        String o1Name = o1.getName();
        String o2Name = o2.getName();
        int minLen = com.gokdenizozkan.util.Math.min(o1Name.length(), o2Name.length());
        
        for (int i = 0; i < minLen; i++) {
            if (o1Name.charAt(i) > o2Name.charAt(i)) return 1;
            if (o1Name.charAt(i) < o2Name.charAt(i))  return -1;
        }
        return 0;
    }
    */
    
}
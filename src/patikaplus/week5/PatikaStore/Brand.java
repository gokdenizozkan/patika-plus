package patikaplus.week5.PatikaStore;

public class Brand implements Comparable<Brand> {
    private int id;
    private String name;
    private static int idToAssign = 0; 
    
    protected Brand(String name) {
        this.name = name;
        this.id = idToAssign++;
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
}
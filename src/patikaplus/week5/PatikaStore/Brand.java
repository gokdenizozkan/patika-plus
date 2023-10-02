protected class Brand implements Comparable<Brand> {
    private int id;
    private String name;
    private static int idToAssign = 0; 
    
    protected Brand(String name) {
        this.name = name;
        this.id = idToAssign++;
    }
    
    @Override
    int toCompare(Brand o) {
        if (this.name > o.getName()) return 1;
        if (this.name == o.getName()) return 0;
        if (this.name < o.getName()) return -1;
    }
    
    public String getName() {
        return name;
    }
}
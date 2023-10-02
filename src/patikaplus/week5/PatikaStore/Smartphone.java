protected class Smartphone extends Product {
    private int memory;
    private float screenSize;
    private int battery;
    private int ram;
    private Color color;
    
    protected Smartphone(Brand brand, String name, int unitPrice, int stockAmount, float discountRate,
                        int memory, float screenSize, int battery, int ram, Color Color) {
        super(brand, name, unitPrice, stockAmount, discountRate);
        this.memory = memory;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }
    
    protected enum Color {
        BLACK, RED, BLUE;
    }    
}
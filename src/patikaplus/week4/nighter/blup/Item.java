package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.arran.Id;

public class Item {
    private final Id id = new Id(Id.Type.ITEM);
    private int price;
    private String name;
    private boolean unique; // Price -1 makes it unique

    public Item(int price, String name) {
        this.price = price;
        this.name = name;
        this.unique = (price == -1);
    }

    public boolean isUnique() {
        return unique;
    }

    public static class Builtin {
        public static Item firewood = new Item(-1, "Firewood");
        public static Item water = new Item(-1, "Water");
        public static Item food = new Item(-1, "Food");
    }
}

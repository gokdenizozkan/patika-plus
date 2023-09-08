package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.blup.Item;

public class Armor extends Item {
    private int defPoint;
    public Armor(int price, String name, boolean unique, int defPoint) {
        super(price, name);
        this.defPoint = defPoint;
    }

    public int getDefPoint() {
        return defPoint;
    }
}

package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.blup.Item;

public class Weapon extends Item {
    private int atkPoint;
    public Weapon(int price, String name, boolean unique, int atkPoint) {
        super(price, name);
        this.atkPoint = atkPoint;
    }

    public int getAtkPoint() {
        return atkPoint;
    }
}

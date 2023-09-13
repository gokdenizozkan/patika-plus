package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.util.Tengri;

import java.util.ArrayList;

public class Holder {
    private String name;
    private ArrayList<Item> slots = new ArrayList<>();
    private int gold = 0;
    private boolean empty = false;


    Holder() {
        this.empty = true;
    }

    Holder(int gold) {
        this.gold = gold;
    }

    Holder(Item... items) {
        for (Item i : items) {
            slots.add(i);
        }
    }

    Holder(int gold, Item... items) {
        this.gold = gold;
        for (Item i : items) {
            slots.add(i);
        }
    }

    public void add(int gold) {
        this.gold += gold;
    }

    public void add(Item item) {
        slots.add(item);
    }

    public void remove(int gold) {
        this.gold -= gold;
    }

    public void remove(Item item) {
        slots.remove(item);
    }

    public void transferGold(Holder target, int amount) {
        target.add(amount);
        remove(amount);
    }

    public void transferItem(Holder target, Item item) {
        target.add(item);
        slots.remove(item);
    }

    public void transferItems(Holder target, Item... items) {
        for (Item i : items) {
            target.add(i);
        }
    }

    public void transferAll(Holder target) {
        target.add(gold);
        remove(gold);
        transferItems(target, slots.toArray(new Item[slots.size()]));
    }

    public Item dropItem() {
        return slots.get(Tengri.range(slots.size()));
    }

    public boolean isEmpty() {
        return empty;
    }
}

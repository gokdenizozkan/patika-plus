package patikaplus.week4.nighter.blup;

public class Armor extends Item {
    private int defPoint;
    public Armor(int price, String name, int defPoint) {
        super(price, name);
        this.defPoint = defPoint;
    }

    public int getDefPoint() {
        return defPoint;
    }
}

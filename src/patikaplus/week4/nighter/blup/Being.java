package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.prod.Armor;
import patikaplus.week4.nighter.prod.Inventory;
import patikaplus.week4.nighter.prod.Weapon;
import patikaplus.week4.nighter.arran.Signal;

public abstract class Being {
    private String name;
    private Vessel charClass;
    private int health;
    private int maxHealth;
    private int totalDamage;
    Inventory inventory;
    Armor armor;
    Weapon weapon;

    Location currentLocation;

    Signal died;
    Signal attacked;
    Signal fled;

    public Being() {
        this.died = Signal.DIED;
        this.attacked = Signal.ATTACKED;
        this.fled = Signal.FLED;
    }

    private void attack() {
        attacked.emit(calcDamage());
    }

    private void defend() {
        //
    }

    private void flee() {
        fled.emit();
    }

    public int calcDamage() {
        return 0;
    }

    public void takeDamage(int amount) {
        amount -= calcProtection();
        if (amount > 0) {
            health -= amount;
        }
    }

    private int calcProtection() {
        return 0;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}

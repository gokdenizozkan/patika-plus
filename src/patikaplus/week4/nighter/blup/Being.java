package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.arran.Signal;
import patikaplus.week4.nighter.util.Tengri;

public class Being {
    private final Vessel vessel;
    private final Signal died;
    private final Signal attacked;
    private final Signal defended;
    private final Signal fled;

    private Holder inventory;
    private Armor armor;
    private Weapon weapon;
    private Location currentLocation;
    private String name;
    private int currentHealth;
    private int maxHealth;
    private int totalDamage;
    private boolean combatStateDefending;

    public Being(String name, Vessel vessel) {
        this.died = new Signal(this, Signal.Type.DIED);
        this.attacked = new Signal(this, Signal.Type.ATTACKED);
        this.defended = new Signal(this, Signal.Type.DEFENDED);
        this.fled = new Signal(this, Signal.Type.FLED);

        this.name = name;
        this.vessel = vessel;

        this.maxHealth = this.vessel.getBaseHealth();
        this.currentHealth = maxHealth;

        this.totalDamage = (this.vessel.getBaseDamage());
    }

    public void attack() {
        combatStateDefending = false;
        attacked.emit(calcDamage());
    }

    public void defend() {
        combatStateDefending = true;
        defended.emit();
    }

    public void flee() {
        if (Tengri.flipCoin()) {
            fled.emit();
        }
    }

    public int calcDamage() {
        return totalDamage;
    }

    public void takeDamage(int amount) {
        amount -= calcProtection();
        if (amount > 0) {
            currentHealth -= amount;
        }

        if (currentHealth <= 0) {
            died.emit();
        }
    }

    private int calcProtection() {
        int protection = armor.getDefPoint();
        if (combatStateDefending) protection += (totalDamage / 4);
        return protection;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDead() {
        return this.currentHealth <= 0;
    }

    public Holder getInventory() {
        return inventory;
    }
}

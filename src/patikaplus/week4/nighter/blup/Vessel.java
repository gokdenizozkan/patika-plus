package patikaplus.week4.nighter.blup;

import patikaplus.week4.nighter.arran.Id;

public class Vessel {
    private final Id id = new Id(Id.Type.VESSEL);
    private final String genericName;
    private final int baseHealth;
    private final int baseDamage;
    private final int startingGold;
    private final boolean canBeUsedByPlayer;

    public boolean isCanBeUsedByPlayer() {
        return canBeUsedByPlayer;
    }

    Vessel(String genericName, int baseHealth, int baseDamage, int startingGold, boolean canBeUsedByPlayer) {
        this.genericName = genericName;
        this.baseHealth = baseHealth;
        this.baseDamage = baseDamage;
        this.startingGold = startingGold;
        this.canBeUsedByPlayer = canBeUsedByPlayer;
    }

    public Id getId() {
        return id;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getStartingGold() {
        return startingGold;
    }

    public String getGenericName() {
        return genericName;
    }

    public static class Builtin {
        public static Vessel samurai = new Vessel("Samurai", 21, 5, 15, true);
        public static Vessel archer = new Vessel("Archer", 18, 7, 20, true);
        public static Vessel knight = new Vessel("Knight", 24, 8, 5, true);
        public static Vessel zombie = new Vessel("Zombie", 10, 3, 4, false);
        public static Vessel vampire = new Vessel("Vampire", 14, 4, 7, false);
        public static Vessel bear = new Vessel("Bear", 20, 7, 12, false);

    }
}

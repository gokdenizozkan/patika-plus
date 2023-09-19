package patikaplus.week4.nighter.blup;

import patikaplus.util.Array;
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
    
    public String getDetails() {
		return String.format(
				"""
				(%d) %s
				Health: %d
				Damage: %d
				Gold: %d
				""",
				id.getValue(), genericName, baseHealth, baseDamage, startingGold);
    }
    
    @Override
    public String toString() {
    	return genericName;
    }

    public static class Builtin {
    	private static Vessel[] vessels;
    	private static Vessel[] vesselsPlayer = new Vessel[1];
    	
        private static Vessel samurai;
        private static Vessel archer;
        private static Vessel knight;
        private static Vessel zombie;
        private static Vessel vampire;
        private static Vessel bear;
    	
    	static {
        	samurai = new Vessel("Samurai", 21, 5, 15, true);
        	archer = new Vessel("Archer", 18, 7, 20, true);
        	knight = new Vessel("Knight", 24, 8, 5, true);
       		zombie = new Vessel("Zombie", 10, 3, 4, false);
        	vampire = new Vessel("Vampire", 14, 4, 7, false);
        	bear = new Vessel("Bear", 20, 7, 12, false);
        	
        	vessels = new Vessel[]{samurai, archer, knight, zombie, vampire, bear};
        	
        	Object[] temp = new Object[1];
        	int e = 0;
        	for (int i = 0; i < vessels.length; i++) {
        		if (vessels[i].canBeUsedByPlayer) {
        			if (vesselsPlayer.length <= i) {
        				temp = Array.copyAndEnlarge(temp, 1, true);
        			}
        			temp[e] = vessels[i];
        			e++;
        		}
        	}
        	
        	vesselsPlayer = new Vessel[temp.length];
        	for (int i = 0; i < temp.length; i++) {
        		vesselsPlayer[i] = (Vessel) temp[i];
        	}
    	}
 
    	public static Vessel[] getVessels() {
    		return vessels;
    	}
    	
    	public static Vessel[] getVesselsPlayer() {
    		return vesselsPlayer;
    	}

    }
}

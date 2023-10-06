package dev.patika.plus.week4.adventuregame;

public class Inventory {
	private Weapon weapon;
	private Armor armor;
	
	
	public Inventory() {
		this.weapon = new Weapon(0, "Fists", 1, 0);
		this.armor = new Armor(0, "Leaf", 1, 0);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	
}

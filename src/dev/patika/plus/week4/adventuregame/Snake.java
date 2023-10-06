package dev.patika.plus.week4.adventuregame;

import java.util.Random;

public class Snake extends Creature {

	public Snake() {
		super(4, "Snake", new Random().nextInt(3, 7), 12, -1);
	}
	
	public int getDropType() {
		int percentage = new Random().nextInt(101);
		
		if (percentage < 15) {
			return 0;
		}
		else if (percentage < 30) {
			return 1;
		}
		else if (percentage < 55) {
			return 2;
		}
		else {
			return 3;
		}
	}
	
	public Weapon dropWeapon() {
		int percentage = new Random().nextInt(101);
		if (percentage < 20) {
			return Weapon.getWeapon(3);
		}
		else if (percentage < 50) {
			return Weapon.getWeapon(2);
		}
		else {
			return Weapon.getWeapon(1);
		}
	}
	
	public Armor dropArmor() {
		int percentage = new Random().nextInt(101);
		if (percentage < 20) {
			return Armor.getArmor(3);
		}
		else if (percentage < 50) {
			return Armor.getArmor(2);
		}
		else {
			return Armor.getArmor(1);
		}
	}
	
	public int dropMoney() {
		int percentage = new Random().nextInt(101);
		if (percentage < 20) {
			return 10;
		}
		else if (percentage < 50) {
			return 5;
		}
		else {
			return 1;
		}
	}
}

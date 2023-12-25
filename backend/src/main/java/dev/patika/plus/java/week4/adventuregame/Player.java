package dev.patika.plus.java.week4.adventuregame;

import java.util.Scanner;

public class Player {
	private Scanner sc = new Scanner(System.in);
	
	private int damage;
	private int health;
	private int money;
	private int replenishedHealth;
	private String charName;
	private String name;
	private Inventory inventory;
	private String[] lootedUniqueItems = new String[3];

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	public void selectChar() {
		GameChar[] charList = {new Samurai(), new Knight(), new Archer()};
		for (int i = 0; i < charList.length; i++) {
			GameChar gC = charList[i];
			System.out.printf("(%d) %s\nDamage: %d\tHealth: %d\tMoney: %d\n", i + 1, gC.getName(), gC.getDamage(), gC.getHealth(), gC.getMoney());
		}
		switch (sc.nextInt()) {
			case 1 -> {
				initPlayer(charList[0]);
			}
			case 2 -> {
				initPlayer(charList[1]);
			}
			case 3 -> {
				initPlayer(charList[2]);
			}
			default -> {
				initPlayer(charList[0]);
			}
		}
		System.out.printf("You have chosen to become %s. You now posses their attributes.\n", charName);
	}
	
	private void initPlayer(GameChar gameChar) {
		damage = gameChar.getDamage();
		health = gameChar.getHealth();
		money = gameChar.getMoney();
		charName = gameChar.getName();
		this.replenishedHealth = health;
	}
	
	public void printInfo() {
		System.out.printf("%s, host of %s\nDamage: %d\tHealth: %d\tMoney: %d\nInventory:\nWeapon: %s\n", name, charName, damage, health, money, inventory.getWeapon().getName());
	}
	
	public int getTotalDamage() {
		return damage + inventory.getWeapon().getDamage();
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Weapon getWeapon() {
		return this.inventory.getWeapon();
	}

	public String[] getLootedUniqueItems() {
		return lootedUniqueItems;
	}

	public void setLootedUniqueItems(String[] lootedUniqueItems) {
		this.lootedUniqueItems = lootedUniqueItems;
	}

	public int getReplenishedHealth() {
		return replenishedHealth;
	}

	public void setReplenishedHealth(int replenishedHealth) {
		this.replenishedHealth = replenishedHealth;
	}
	
	
}

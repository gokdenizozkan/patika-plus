package dev.patika.plus.week4.adventuregame;

public class Creature {
	private int id;
	private int damage;
	private int health;
	private String name;
	private int loot;
	private int respawnHealth;
	
	public Creature(int id, String name, int damage, int health, int loot) {
		super();
		this.id = id;
		this.damage = damage;
		this.health = health;
		this.name = name;
		this.loot = loot;
		this.respawnHealth = health;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getLoot() {
		return loot;
	}

	public void setLoot(int loot) {
		this.loot = loot;
	}

	public int getRespawnHealth() {
		return respawnHealth;
	}

	public void setRespawnHealth(int respawnHealth) {
		this.respawnHealth = respawnHealth;
	}
	
}

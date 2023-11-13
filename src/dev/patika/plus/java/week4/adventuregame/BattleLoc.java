package dev.patika.plus.java.week4.adventuregame;

import java.util.Random;

public class BattleLoc extends Location {
	private Creature creature;
	private String loot;
	private int maxCreature;

	public BattleLoc(Player player, String name, Creature creature, String loot, int maxCreature) {
		super(player, name);
		this.creature = creature;
		this.loot = loot;
		this.maxCreature = maxCreature;
	}

	@Override
	public boolean onLocation() {
		int creatureCount = getRandomCreatureCount();
		System.out.printf("You are walking around %s.\nSuddenly you are confronted with %d %s!\n", this.getName(), creatureCount, this.creature.getName());
		System.out.print("What are you gonna do?\n1 - Fight\t2 - Try to run away\n");
		switch (sc.nextInt()) {
			case 1 -> {
				if (combat(creatureCount)) {
					if (this.creature.getId() == 4) break;
					
					System.out.println("You slaughtered them all!");
					for (String s : this.player.getLootedUniqueItems()) {
						if (s == this.loot) {
							return true;
						}
					}
					String[] playerLoots = this.player.getLootedUniqueItems();
					for (int i = 0; i < playerLoots.length; i++) {
						if (playerLoots[i] == null) {
							playerLoots[i] = this.loot;
							return true;
						}
					}
					this.player.setLootedUniqueItems(playerLoots);
				}
				else {
					System.out.println("You are dead...");
					return false;
				}
			}
			case 2 -> {
				return true;
			}
			default -> {
				System.out.printf("When you were about to scream 'Pen pineapple apple pen!' the %s attacked you. The last thing you saw before waving your hand to life was the eyes of it.\n", this.creature.getName());
				return false;
			}
		}
		return true;
	}
	
	public boolean combat(int creatureCount) {
		for (int i = 1; i <= creatureCount; i++) {
			this.creature.setHealth(this.creature.getRespawnHealth());
			while (this.player.getHealth() > 0 && this.creature.getHealth() > 0) {
				System.out.println("----- New Turn Starts -----");
				printPlayerStats();
				printCreatureStats(i);
				boolean playersTurn = Math.random() < 0.5f;
				if (playersTurn) {
					System.out.println("--- your turn! ---");
					System.out.print("\nWhat are you gonna do?\n1 - Attack\t2 - Try to run away\n");
					switch (sc.nextInt()) {
						case 1 -> {
							System.out.printf("You have dealt %d damage.\n", this.player.getTotalDamage());
							this.creature.setHealth(this.creature.getHealth() - this.player.getTotalDamage());;
							
							if (this.creature.getHealth() <= 0) {
								System.out.println("You have killed your enemy and looted it!");
								if (this.creature.getId() == 4) {
									Snake drop = new Snake();
									switch (drop.getDropType()) {
										case 0 -> {
											Weapon droppedLoot= drop.dropWeapon();
											if (droppedLoot.getDamage() < this.player.getWeapon().getDamage()) {
												System.out.println("Your enemy dropped a weapon but its stats are lower than yours.\nYou just ignored the loot.");
												break;
											}
											else {
												System.out.println("You earned " + droppedLoot.getName() + "! You threw your current weapon away.");
												this.player.getInventory().setWeapon(droppedLoot);
												break;
											}
										}	
										case 1 -> {
											Armor droppedLoot= drop.dropArmor();
											if (droppedLoot.getProtection() < this.player.getInventory().getArmor().getProtection()) {
												System.out.println("Your enemy dropped an armor but its stats are lower than yours.\nYou just ignored the loot.");
												break;
											}
											else {
												System.out.println("You earned " + droppedLoot.getName() + "! You threw your current armor away.");
												this.player.getInventory().setArmor(droppedLoot);
												break;
											}	
										}
										case 2 -> {
											int droppedLoot= drop.dropMoney();
											System.out.println("You earned " + droppedLoot + " money!");
											this.player.setMoney(this.player.getMoney() + droppedLoot);
											break;
										}
										case 3 -> {
											break;
										}
									}
								}
								else {
									this.player.setMoney(this.player.getMoney() + creature.getLoot());
									System.out.println("Earned " + this.creature.getLoot() + "money.");
									break;
								}
							}
						}
						case 2 -> {
							return true;
						}
					}
				}	
				else {
					System.out.println("--- enemy's turn! ---");
					int creatureDamage = this.creature.getDamage() - this.player.getInventory().getArmor().getProtection();
					if (creatureDamage <= 0) {
						System.out.println("You have taken no damage!");
					}
					else {
						System.out.printf("You have taken %d damage.\n", this.creature.getDamage());
						this.player.setHealth(this.player.getHealth() - this.creature.getDamage());
					}
				}
				playersTurn = !playersTurn;
			}
			if (this.player.getHealth() < 0) {
				return false;
			}
			else {
				if (this.creature.getId() != 4) {
					System.out.println("Earned " + this.loot);
				}
				return true;
			}
		}
		return false;
	}
	
	public void printPlayerStats() {
		System.out.printf("Player Stats:	%d HP	%d AP\n", this.player.getHealth(), this.player.getTotalDamage());
	}

	public void printCreatureStats(int i) {
		System.out.printf("%d. Creature:	%d HP	%d AP\n", i, this.creature.getHealth(), this.creature.getDamage());
	}
	
	public int getRandomCreatureCount() {
		return new Random().nextInt(3) + 1;
	}

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public String getLoot() {
		return loot;
	}

	public void setLoot(String loot) {
		this.loot = loot;
	}

	public int getMaxCreature() {
		return maxCreature;
	}

	public void setMaxCreature(int maxCreature) {
		this.maxCreature = maxCreature;
	}

}

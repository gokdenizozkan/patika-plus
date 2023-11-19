package dev.patika.plus.java.week4.adventuregame;

import java.util.Scanner;

// This package is not written by me, but modified to add new functionality and improvements.

public class Game {
	private Scanner sc = new Scanner(System.in);
	private boolean win = false;
	
	public void start() {
		System.out.println("Welcome to your Adventure!");
		System.out.print("Please enter a name: ");
		String playerName = sc.nextLine();
		Player player = new Player(playerName);
		System.out.printf("Welcome %s, what you are about to experience is\nnothing but realities of horror\nresiding deep within this earth.\n", player.getName());
		System.out.println("Now is the time for your faith to be written in a vessel of your choice:");
		player.selectChar();
		
		Location location = null;
		while (true) {
			System.out.println();
			player.printInfo();
			System.out.println();
			//System.out.printf("Carefully looking around, you realize you are in %s\n", location);
			System.out.printf("You open your map:\n1 - Safehouse\t2 - Store\t3 - Cave\t4 - Forest\t5 - River\t6 - Mine\n");
			System.out.print("Choose the location you want to go: ");
			switch (sc.nextInt()) {
				case 1 -> {
					location = new Safehouse(player);
					if (new Safehouse(player).isLootedAll()) {
						win = true;
						break;
					}
				}
				case 2 -> {
					location = new Store(player);
				}
				case 3 -> {
					location = new Cave(player);
					for (String s : player.getLootedUniqueItems()) {
						if (s == new Cave(player).getLoot()) {
							location.setLocked(true);
						}
					}
				}
				case 4 -> {
					location = new Forest(player);
					for (String s : player.getLootedUniqueItems()) {
						if (s == new Forest(player).getLoot()) {
							location.setLocked(true);
						}
					}
				}
				case 5 -> {
					location = new River(player);
					for (String s : player.getLootedUniqueItems()) {
						if (s == new River(player).getLoot()) {
							location.setLocked(true);
						}
					}
				}
				case 6 -> {
					location = new Mine(player);
				}
				default -> {
					location = new Safehouse(player);
				}
			}
			System.out.println();
			if (win) {
				System.out.println("YOU WIN!");
			}
			if (location.isLocked()) {
				System.out.println("You already got the loot, no need to go back!");
				continue;
			}
			else if (location.onLocation() == false) {
				System.out.println("GAME OVER");
				break;
			}
		}
	}
}
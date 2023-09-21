package patikaplus.week4.adventuregame;

import java.util.Scanner;

public abstract class Location {
	protected static Scanner sc = new Scanner(System.in);
	protected Player player;
	private String name;
	private boolean locked;
	
	public Location(Player player, String name) {
		this.player = player;
		this.name = name;
	}
	
	public abstract boolean onLocation();

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}

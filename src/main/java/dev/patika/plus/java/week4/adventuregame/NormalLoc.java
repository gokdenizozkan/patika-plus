package dev.patika.plus.java.week4.adventuregame;

public abstract class NormalLoc extends Location {

	public NormalLoc(Player player, String name) {
		super(player, name);
	}
	
	@Override
	public boolean onLocation() {
		return true;
	}

}

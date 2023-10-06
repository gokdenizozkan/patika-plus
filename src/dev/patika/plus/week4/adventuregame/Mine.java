package dev.patika.plus.week4.adventuregame;

public class Mine extends BattleLoc {

	public Mine(Player player) {
		super(player, "Mine", new Snake(), "rand", 5);
	}
}

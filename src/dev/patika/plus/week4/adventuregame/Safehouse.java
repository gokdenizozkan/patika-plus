package dev.patika.plus.week4.adventuregame;

public class Safehouse extends NormalLoc {
	private boolean lootedAll = false;

	public Safehouse(Player player) {
		super(player, "Safehouse");
	}
	
	@Override
	public boolean onLocation() {
		int count = 0;
		for (String s : this.player.getLootedUniqueItems()) {
			if (s == null) {
				count++;
				break;
			}
		}
		
		if (count == 0) {
			System.out.println("YOU WIN!");
		}
		else {
			System.out.println("Having a chill moment in your safehouse.");
			System.out.println("You are replenished.");
			this.player.setHealth(this.player.getReplenishedHealth());
		}
		return true;
	}
	
	public boolean isLootedAll() {
		return lootedAll;
	}

}

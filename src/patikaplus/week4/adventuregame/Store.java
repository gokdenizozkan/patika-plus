package patikaplus.week4.adventuregame;

public class Store extends NormalLoc {

	public Store(Player player) {
		super(player, "Store");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("A warm bonfire and its sounds feel comforting.\nMerchant of all sort is looking at you.");
		System.out.println("1 - Weapons\t2 - Armors\t-9 - Exit");
		System.out.print("Choose your action: ");
		switch (Location.sc.nextInt()) {
			case 1 -> {
				printWeapon();
				purchaseWeapon();
			}
			case 2 -> {
				printArmor();
				purchaseArmor();
			}
			case -9 -> {
				System.out.println("Merchant laughs hysterically. You get out of the store.");
				return true;
			}
			default -> {
				System.out.println("You raised your hands,\nfirmed a pen with one and an apple with the other.\nScreamed 'Apple pen!' while making a terrifying smile.\nMerchant was about to shoot you with a shotgun\nbut you managed to get out of the store.");
				return true;
			}
		}
		return true;
	}
	
	public void printWeapon() {
		for (Weapon w : Weapon.weapons()) {
			System.out.printf("(%d) %s\nDamage: %d\tPrice: %d\n", w.getId(), w.getName(), w.getDamage(), w.getPrice());
		}
	}
	
	public void purchaseWeapon() {
		System.out.print("Choose your new weapon:\n(-9 to exit) ");
		int in = sc.nextInt();
		if (in < 1) {
			System.out.println("You raised your hands,\nfirmed a pen with one and a pineapple with the other.\nScreamed 'Pineapple pen!' while making a terrifying smile.\nMerchant was about to shoot you with a shotgun\nbut you managed to get out of the store.");
			return;
		}
		
		Weapon selectedWeapon = Weapon.getWeapon(in);
		if (selectedWeapon == null) return;
		if (selectedWeapon.getPrice() > this.player.getMoney()) {
			this.player.setMoney(0);
			System.out.println("Your money is not sufficient to buy this weapon.\nMerchant is pissed off by your ignorant choice.\nHe pulled all the money you have out of your hand.\nPointed his shotgun to your face, made you get out.");
		}
		else {
			this.player.setMoney(this.player.getMoney() - selectedWeapon.getPrice());
			this.player.getInventory().setWeapon(selectedWeapon);
			System.out.printf("You purchased %s!\nMerchant seems content.\nThough your pocket seems to disagree as it have %d money left.\n", selectedWeapon.getName(), this.player.getMoney());
		}
	}
	
	public void printArmor() {
		for (Armor a : Armor.armors()) {
			System.out.printf("(%d) %s\nProtection: %d\tPrice: %d\n", a.getId(), a.getName(), a.getProtection(), a.getPrice());
		}
	}
	
	public void purchaseArmor() {
		System.out.print("Choose your new armor:\n(-9 to exit) ");
		int in = sc.nextInt();
		if (in < 1) {
			System.out.println("You raised your hands,\napple pen... pineapple pen...!\nScreamed 'Pen pineapple apple pen!' while making a terrifying smile.\nMerchant was about to shoot you with a shotgun\nbut you managed to get out of the store.");
			return;
		}
		
		Armor selectedArmor = Armor.getArmor(in);
		if (selectedArmor == null) return;
		if (selectedArmor.getPrice() > this.player.getMoney()) {
			this.player.setMoney(0);
			System.out.println("Your money is not sufficient to buy this armor.\nMerchant is pissed off by your ignorant choice.\nHe pulled all the money you have out of your hand.\nPointed his shotgun to your face, made you get out.");
		}
		else {
			this.player.setMoney(this.player.getMoney() - selectedArmor.getPrice());
			this.player.getInventory().setArmor(selectedArmor);
			System.out.printf("You purchased %s!\nMerchant seems content.\nThough your pocket seems to disagree as it have %d money left.\n", selectedArmor.getName(), this.player.getMoney());
		}
	}
}

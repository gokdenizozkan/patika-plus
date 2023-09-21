package patikaplus.week4.adventuregame;
// 11.03
public class Armor {
	private int id;
	private String name;
	private int protection;
	private int price;
	
	public Armor(int id, String name, int protection, int price) {
		this.id = id;
		this.name = name;
		this.protection = protection;
		this.price = price;
	}
	
	public static Armor[] armors() {
		Armor[] armors = new Armor[3];
		armors[0] = new Armor(1, "Lightweight", 1, 15);
		armors[1] = new Armor(2, "Medium", 3, 25);
		armors[2] = new Armor(3, "Highload", 5, 40);
		return armors;
	}

	public static Armor getArmor(int armorId) {
		for (Armor a : Armor.armors()) {
			if (a.getId() == armorId) return a;
		}
		return null;
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
	
	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

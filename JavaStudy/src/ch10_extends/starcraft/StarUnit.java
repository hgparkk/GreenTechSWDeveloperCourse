package ch10_extends.starcraft;

public class StarUnit {
	private String name;
	private int hp;
	private int damage;
	private int armor;
	
	public StarUnit() {}
	
	public StarUnit(String name, int hp, int damage, int armor) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void move(int x, int y) {
		System.out.println(x + "," + y + " 지점으로 이동");
	}
}
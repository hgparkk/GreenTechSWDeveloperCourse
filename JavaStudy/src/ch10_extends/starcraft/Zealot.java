package ch10_extends.starcraft;

public class Zealot extends StarUnit {
	private int shield;

	public Zealot() {
		this("질럿",100,16,1,60);
	}

	public Zealot(String name, int hp, int damage, int armor, int shield) {
		super(name, hp, damage, armor);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public String toString() {
		return "Zealot [name=" + getName() + ", hp=" + getHp() + ", damage=" + getDamage() + ", armor=" + getArmor()
				+ ", shield=" + shield + "]";
	}
}
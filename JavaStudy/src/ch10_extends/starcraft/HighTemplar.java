package ch10_extends.starcraft;

public class HighTemplar extends StarUnit {
	private int sheild;
	private int mp;

	public HighTemplar() {
		this("하이템플러", 40, 0, 0, 40, 200);
	}

	public HighTemplar(String name, int hp, int damage, int armor, int shield, int mp) {
		super(name, hp, damage, armor);
		this.sheild = shield;
		this.mp = mp;
	}

	public void storm() {
		System.out.println("사이오닉 스톰!!");
	}

	@Override
	public String toString() {
		return "HighTemplar [name=" + getName() + ", hp=" + getHp() + ", damage=" + getDamage() + ", armor="
				+ getArmor() + ", sheild=" + sheild + ", mp=" + mp + "]";
	}
}
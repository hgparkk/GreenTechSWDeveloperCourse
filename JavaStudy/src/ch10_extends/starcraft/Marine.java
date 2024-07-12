package ch10_extends.starcraft;

public class Marine extends StarUnit {
	public Marine() {
		this("마린", 50, 6, 0);
	}

	public Marine(String name, int hp, int damage, int armor) {
		super(name, hp, damage, armor);
	}

	public void move(int x, int y) {
		System.out.println(x + "," + y + " 지점으로 이동");
	}

	public void attack(StarUnit target) {
		target.setHp(target.getHp() - getDamage());
		System.out.println("투두두두");
	}

	public void stimpack() {
		setHp(getHp() - 10);
		System.out.println("공격속도 증가");
	}

	@Override
	public String toString() {
		return "Marine [name=" + getName() + ", hp=" + getName() + ", damage=" + getDamage() + ", armor=" + getArmor()
				+ "]";
	}
}
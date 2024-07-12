package ch11_interface.lol;

public class Fizz implements Skill{
	String name;
	int damage;
	int hp;
	
	public void skillQ() {
		System.out.println("적에게 돌진");
	}
	
	public void skillW() {
		System.out.println("공격 강화");
	}
	
	public void skillE() {
		System.out.println("재간둥이");
	}
	
	public void skillR() {
		System.out.println("상어 소환");
	}
}
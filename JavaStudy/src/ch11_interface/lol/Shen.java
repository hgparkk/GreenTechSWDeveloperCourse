package ch11_interface.lol;

public class Shen implements Skill{
	String name;
	int damage;
	int hp;
	
	public void skillQ() {
		System.out.println("공격 3번 강화");
	}
	
	public void skillW() {
		System.out.println("보호막 생성");
	}
	
	public void skillE() {
		System.out.println("도발");
	}
	
	public void skillR() {
		System.out.println("아군에게 순간이동");
	}
}
package ch10_extends.starcraft;

import java.util.ArrayList;

public class StarcraftMain {
	public static void main(String[] args) {
		Marine marine = new Marine("마린",50,6,0);
		System.out.println(marine);
		
		Marine marine2 = new Marine();
		System.out.println(marine2);
		
		marine.move(10,30);
		marine.stimpack();
		System.out.println(marine);
		
		Zealot zealot1 = new Zealot();
		Zealot zealot2 = new Zealot();
		Zealot zealot3 = new Zealot();
		Zealot zealot4 = new Zealot();
		Zealot zealot5 = new Zealot();
		Zealot zealot6 = new Zealot();
		
		ArrayList<Zealot> zealotList = new ArrayList<>();
		
		zealotList.add(zealot1);
		zealotList.add(zealot2);
		zealotList.add(zealot3);
		zealotList.add(zealot4);
		zealotList.add(zealot5);
		zealotList.add(zealot6);
		
		for(int i=0;i<zealotList.size();i++) {
			zealotList.get(i).move(30, 60);
		}
		
		HighTemplar highTemplar = new HighTemplar();
		
		ArrayList<StarUnit> starList = new ArrayList<>();
		
		starList.add(zealot1);
		starList.add(zealot2);
		starList.add(zealot3);
		starList.add(zealot4);
		starList.add(zealot5);
		starList.add(zealot6);
		starList.add(highTemplar);
		
		for(int i=0;i<starList.size();i++) {
			starList.get(i).move(20, 40);
		}
		
		System.out.println(zealot1);
		marine.attack(zealot1);
		System.out.println(zealot1);
		
		System.out.println(highTemplar);
		marine.attack(highTemplar);
		System.out.println(highTemplar);
		
		System.out.println(starList.get(6));
		
		((HighTemplar)starList.get(6)).storm();
		
		for(int i=0;i<starList.size();i++) {
			if(starList.get(i) instanceof HighTemplar) {
				((HighTemplar)starList.get(i)).storm();
			}
		}
	}
}
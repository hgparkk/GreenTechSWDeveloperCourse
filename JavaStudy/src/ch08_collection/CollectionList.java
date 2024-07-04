package ch08_collection;

import java.util.ArrayList;

public class CollectionList {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<String> strList2 = new ArrayList<>(); // new 뒤에 타입을 명시하지 않아도 된다.

		// ArrayList<int> intList = new ArrayList<>(); 컬렉션 객체는 참조타입 객체만 담을 수 있다.
		ArrayList<Integer> intList = new ArrayList<>(); // 해당 기본타입의 Wrapper Class를 이용한다.
		
		System.out.println(intList.size());
		System.out.println(intList);
		
		intList.add(1);
		intList.add(5);
		intList.add(3);
		
		System.out.println(intList.size());
		System.out.println(intList);
	}
}

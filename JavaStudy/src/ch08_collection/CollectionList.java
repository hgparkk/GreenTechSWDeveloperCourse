package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CollectionList {
	public static void main(String[] args) {
		ArrayList<String> stuList = new ArrayList<String>();
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

		// intList .add("문자열"); 타입과 일치하지 않는 데이터는 추가할 수 없다.

		System.out.println(intList.get(1));

		intList.set(1, 2);

		System.out.println(intList);

		System.out.println(intList.contains(2));
		System.out.println(intList.contains(4));

		System.out.println(intList.indexOf(2));
		System.out.println(intList.indexOf(4));

		System.out.println(intList.indexOf(2) != -1);
		System.out.println(intList.indexOf(4) != -1);

		System.out.println(intList.isEmpty());
		System.out.println(intList.size() == 0);

		intList.remove(1);

		System.out.println(intList);

		System.out.println(intList.size());

		System.out.println(intList.get(1));

		intList.clear();

		System.out.println(intList);

		intList = new ArrayList<>(); // 리스트를 새로 초기화 하면서 리스트를 비우는 역할과 같다.

		System.out.println("=========================================================");

		stuList.add("재민");
		stuList.add("동희");
		stuList.add("현규");
		stuList.add("태권");
		stuList.add("원빈");
		stuList.add("건우");

		System.out.println(stuList);

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		for (int i = 0; i < stuList.size(); i++) {
			stuList.set(i, (i + 1) + ". " + stuList.get(i));
		}

		System.out.println(stuList);

		System.out.println("=========================================================");

		ArrayList<String> copyList = stuList; // 같은 주소값을 넣는다
		System.out.println(copyList);

		copyList.set(0, "1. 효신"); // copyList를 바꾸면 stuList에 영향을 받는다
		System.out.println(stuList);

		ArrayList<String> copyList2 = new ArrayList<>();
		copyList2.addAll(stuList); // 모든 객체를 넣으므로써 복사를 한다.

		System.out.println(copyList2);
		copyList2.set(0, "1. 주형"); // stuList에 영향이 가지 않는다.
		System.out.println(stuList);

		ArrayList<String> copyList3 = new ArrayList<>(stuList); // 생성자를 사용해서 복사를 한다.
		System.out.println(copyList3);

		ArrayList<String> copyList4 = new ArrayList<>();
		for (int i = 0; i < stuList.size(); i++) {
			copyList4.add(stuList.get(i));
		}

		System.out.println(copyList4);

		System.out.println("=========================================================");

		for (String stu : stuList) {
			System.out.println(stu);
		} // for-each 문 : stuList의 크기 만큼 반복, stu에 stuList의 값이 순차적으로 들어간다.

		stuList.forEach(new Consumer<String>() {
			@Override
			public void accept(String stu) {
				System.out.println(stu);
			}
		}); // 자바의 forEach 문 : accept의 param stu에 stuList의 값이 순차적으로 들어간다.

		stuList.forEach(stu -> System.out.println(stu)); // 람다식을 활용한 forEach문

		stuList.forEach(stu -> {
			System.out.println(stu);
			System.out.println(stu);
			System.out.println(stu);
		});

		System.out.println("=========================================================");

		Integer[] numArray = { 30, 23, 1, 66, 34, 143 };
		// List<Integer> numList = Arrays.asList(numArray); 배열을 리스트로

		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(numArray));

		ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(30, 21, 1, 66, 34, 143)); // 굳이 리스트를 할당하지 않아도 리스트로 가능

		for (int k = 0; k < numList.size() - 1; k++) {
			for (int i = 0; i < numList.size() - k - 1; i++) {
				if (numList.get(i) < numList.get(i + 1)) {
					int temp = numList.get(i);
					numList.set(i, numList.get(i + 1));
					numList.set(i + 1, temp);
				}
			}
		}

		System.out.println(numList);

		Collections.sort(numList);

		System.out.println(numList);

		Collections.sort(numList, Collections.reverseOrder());

		System.out.println(numList);
	}
}
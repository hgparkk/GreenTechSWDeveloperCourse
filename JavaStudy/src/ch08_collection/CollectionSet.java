package ch08_collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class CollectionSet {
	public static void main(String[] args) {
		HashSet<String> stuSet = new HashSet<>();

		List<String> stuList = new ArrayList<>(); // 다형성을 이용해 List 에 ArrayList에 넣을 수 있다.

		Set<String> stuSet2 = new HashSet<>();

		stuSet.add("연구");
		stuSet.add("재완");
		stuSet.add("영찬");
		stuSet.add("원빈");

		System.out.println(stuSet); // Set에는 순서가 없다.

		stuSet.add("연구"); // 중복된 값이 들어가지 않는다.

		System.out.println(stuSet.contains("연구"));

		stuSet.remove("연구");
		System.out.println(stuSet);

		stuSet.remove("구연");
		System.out.println(stuSet);

		System.out.println(stuSet.size());

		System.out.println("=========================================================");

		Iterator<String> stuIter = stuSet.iterator();

		while (stuIter.hasNext()) {
			String stu = stuIter.next();
			System.out.println(stu);
		}

		for (String stu : stuSet) {
			System.out.println(stu);
		}

		stuSet.forEach(new Consumer<String>() {
			@Override
			public void accept(String stu) {
				System.out.println(stu);
			}
		});

		stuSet.forEach(stu -> System.out.println(stu));

		System.out.println("=========================================================");

		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			intList.add((int) (Math.random() * 11) + 10);
		}
		System.out.println(intList);

		//Set의 중복을 허용하지 않는 특성을 이용해 중복 제거
		HashSet<Integer> intSet = new HashSet<>();
		for (int i = 0; i < intList.size(); i++) {
			intSet.add(intList.get(i));
		}
		
		System.out.println(intSet);
		
		intSet.clear();
		
		intSet.addAll(intList);
		
		System.out.println(intSet);
		
		intList.clear();
		
		//Set을 다시 List에 담기
		for(int num: intSet) {
			intList.add(num);
		}
		
		System.out.println(intList);
		
		intList.clear();
		
		intList.addAll(intSet);
		
		System.out.println(intList);
	}
}
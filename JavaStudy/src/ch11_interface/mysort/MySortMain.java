package ch11_interface.mysort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ch09_class.school.Student;
import ch10_extends.simple.Parent;

public class MySortMain {
	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<>();

		stuList.add(new Student("짱구", 78, 66, 57));
		stuList.add(new Student("철수", 98, 86, 76));
		stuList.add(new Student("훈이", 88, 69, 74));
		stuList.add(new Student("맹구", 77, 96, 97));
		stuList.add(new Student("유리", 58, 88, 77));

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
		System.out.println();

		Collections.sort(stuList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (o1.getAvg() - o2.getAvg() < 0) ? (-1) : (1);
			}
		});

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		System.out.println("========================================================");

		MyCollections.sort(stuList, new MyComparator<Student>() {
			@Override
			public boolean myCompare(Student left, Student right) {
				return left.getAvg() < right.getAvg();
			}
		});

		MyCollections.sort(stuList, (left, right) -> left.getAvg() < right.getAvg());

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		System.out.println("========================================================");

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		ArrayList<Parent> parentList = new ArrayList<>();

		parentList.add(new Parent("신형만", 30));
		parentList.add(new Parent("봉미선", 25));
		parentList.add(new Parent("호빵맨", 15));
		parentList.add(new Parent("루피", 17));
		parentList.add(new Parent("조로", 18));

		for (int i = 0; i < parentList.size(); i++) {
			System.out.println(parentList.get(i));
		}

		MyCollections.printList(parentList);
		MyCollections.printList(stuList);

		MyCollections.sort(parentList, new MyComparator<Parent>() {
			@Override
			public boolean myCompare(Parent left, Parent right) {
				return left.getAge() > right.getAge();
			}
		});
		
		MyCollections.printList(parentList);
		
		MyCollections.sort(stuList, (left, right) -> left.getKor() > right.getKor());
		
		MyCollections.printList(stuList);
	}
}
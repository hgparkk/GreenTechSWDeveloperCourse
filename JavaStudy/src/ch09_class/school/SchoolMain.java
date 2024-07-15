package ch09_class.school;

import java.util.ArrayList;
import java.util.Collections;

public class SchoolMain {
	public static void main(String[] args) {
		Student hobbang = new Student("호빵맨", 90, 88, 77);

		System.out.println(hobbang);

		System.out.println(hobbang.getName());

		hobbang.setName("찐빵맨");

		System.out.println(hobbang);

		hobbang.setKor(82);
		System.out.println(hobbang);

		hobbang.setEng(90);
		System.out.println(hobbang);

		Student sikbbang = new Student("식빵맨", 95, 91, 90);
		System.out.println(sikbbang);

		ArrayList<Student> stuList = new ArrayList<>();

		stuList.add(hobbang);
		stuList.add(sikbbang);
		stuList.add(new Student("카레빵맨", 79, 85, 65));
		stuList.add(new Student("세균맨", 69, 65, 45));
		stuList.add(new Student("꿀빵맨", 71, 82, 95));
		stuList.add(new Student("호떡맨", 89, 84, 56));

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		System.out.println("========================================================");

		for (int i = 0; i < stuList.size(); i++) {
			for (int j = 0; j < stuList.size() - 1 - i; j++) {
				double stuLeft = stuList.get(j).getAvg();
				double stuRight = stuList.get(j + 1).getAvg();
				if (stuLeft < stuRight) {
					Student temp = stuList.get(j);
					stuList.set(j, stuList.get(j + 1));
					stuList.set(j + 1, temp);
				}
			}
		}

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}

		Collections.sort(stuList, (stuLeft, stuRight) -> ((stuLeft.getAvg() - stuRight.getAvg()) > 0) ? (-1) : (1));

		for (int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i));
		}
	}
}
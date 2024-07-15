package ch09_class.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentMain {
	public static void main(String[] args) {
		Student donghee = new Student();

		donghee.name = "동희";
		donghee.level = 1;
		donghee.exp = 0;

		System.out.println(donghee);

		Student jaemin = new Student("재민", 3, 10);

		System.out.println(jaemin);

		donghee.exp = donghee.exp + 30;
		jaemin.exp += 30;

		if (donghee.exp >= 100) {
			donghee.level += 1;
			donghee.exp -= 100;
		}

		if (jaemin.exp >= 100) {
			jaemin.level += 1;
			jaemin.exp -= 100;
		}

		Student hyosin = new Student("효신", 2, 20);

		Student yeongu = new Student("연구", 1, 0);
		Student jaewan = new Student("재완", 1, 0);

		Student wonbin = new Student("원빈");

		ArrayList<Student> stuList = new ArrayList<>();

		stuList.add(donghee);
		stuList.add(jaemin);
		stuList.add(hyosin);
		stuList.add(yeongu);
		stuList.add(jaewan);
		stuList.add(wonbin);

		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).afterOneDay();
		}

		for (Student s : stuList) {
			s.afterOneDay();
		}

		for (int k = 0; k < 113; k++) {
			for (Student s : stuList) {
				s.afterOneDay();
			}
		}

		Student max = stuList.get(0);
		for (int i = 1; i < stuList.size(); i++) {
			if (max.level < stuList.get(i).level) {
				max = stuList.get(i);
			}
		}
		System.out.println(max);
		
		int count = 0;
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).level == 43) {
				count++;
			}
		}
		System.out.println(count);
		
		for(Student s: stuList) {
			if(s.name.equals("재완")) {
				System.out.println(s);
			}
		}
		
		for(int i=0; i<stuList.size(); i++) {
			for(int j=0; j<stuList.size() -1 - i; j++) {
				int leftExp = stuList.get(j).level * 100 + stuList.get(j).exp;
				int rightExp = stuList.get(j+1).level * 100 + stuList.get(j+1).exp;
				if(leftExp < rightExp) {
					Student temp = stuList.get(j);
					stuList.set(j, stuList.get(j+1));
					stuList.set(j+1, temp);
				}
			}
		}
		
		for(Student s: stuList) {
			System.out.println(s);
		}
		
		System.out.println("========================================================");
		
		for (int k = 0; k < 113; k++) {
			for (Student s : stuList) {
				s.afterOneDay();
			}
		}
		
		Collections.sort(stuList, new Comparator<Student>() {
			@Override
			public int compare(Student stuLeft, Student stuRight) {
				int leftExp = stuLeft.level * 100 + stuLeft.exp;
				int rightExp = stuRight.level *100 + stuRight.exp;
				return rightExp - leftExp;
			}
		});
		
		for(Student s: stuList) {
			System.out.println(s);
		}
		
		Collections.sort(stuList, (stuLeft, stuRight) -> {
			int leftExp = stuLeft.level * 100 + stuLeft.exp;
			int rightExp = stuRight.level *100 + stuRight.exp;
			return rightExp - leftExp;
		});
	}
}
package ch05_control;

public class LoopForMain {
	public static void main(String[] args) {
		System.out.println("1\n2\n3\n4\n5\n6\n7\n8\n9\n10");
		System.out.println("11\n12\n13\n14\n15\n16\n17\n18\n19\n20");

		System.out.println("=========================================================");

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		// System.out.println(i); 초기화식의 변수는 for문 내에서 선언된 것으로 for 문 밖에서 사용 불가

		for (int i = 11; i <= 20; i++) {
			System.out.println(i);
		}

		for (int i = 0; i <= 10; i++) {
			System.out.println("Hello");
		}

		int one = 1;
		for (int i = 0; i <= 10; i++) {
			System.out.println(one++);
		}

		System.out.println("=========================================================");

		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			sum += i;
		}
		System.out.println(sum);

		for (int i = 1; i <= 9; i++) {
			System.out.println("2 x " + i + " = " + 2 * i);
		}

		System.out.println("=========================================================");
		String star = "";
		for (int i = 1; i <= 5; i++) {
			star += "*";
			System.out.println(star);
		}

		for (String s = "*"; s.length() <= 5; s += "*") {
			System.out.println(s);
		}

		for (int i = 0; i < 20; i++) {
			System.out.println("|||||||| " + i);
			if (((i + 1) % 5) == 0) {
				System.out.println("--------");
			}
		}

		System.out.println("=========================================================");

		for (int i = 0; i < 40; i++) {
			if (i % 2 == 0) {
				System.out.println("\\\\\\\\\\\\\\\\ " + i);
			} else {
				System.out.println("//////// " + i);
			}

			if ((i + 1) % 6 == 0) {
				System.out.println("--------");
			}
		}

		System.out.println("=========================================================");

		for (int i = 10; i > 0; i--) {
			System.out.println(i);
		}

		System.out.println("=========================================================");

		String example = "1882299911";
		int sumString = 0;
		for (int i = 0; i < example.length(); i++) {
			int tmp = Integer.parseInt(example.substring(i, i + 1));
			sumString += tmp;
		}

		System.out.println(sumString);

		String syu = "슈슈슈슈슈슈슈슈슈ㅠ슈ㅠ슈ㅠㅅㅅ슛ㅅ슈슈ㅠ슈슈ㅠ슈슈슛";

		int count = 0;
		for (int i = 0; i < syu.length(); i++) {
			String tmp = syu.substring(i, i + 1);
			if (tmp.equals("슈")) {
				count++;
			}
		}
		System.out.println(count);
	}
}

package ch06_method;

public class MethodMain {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1 부터 100까지 더한 값: " + sum);

		printSum(1, 100);

		System.out.println("30 부터 60까지 더한 값: " + (((60 - 30 + 1) * (30 + 60)) / 2));

		printSumNotFor(30, 60);

		System.out.println("25 부터 50까지 더한 값: " + (((50 - 25 + 1) * (25 + 50)) / 2));

		printSumNotFor(25, 50);

		System.out.println("=========================================================");

		println("1 부터 100까지 더한 값: " + sum);
		println("30 부터 60까지 더한 값: " + (((60 - 30 + 1) * (30 + 60)) / 2));
		println("25 부터 50까지 더한 값: " + (((50 - 25 + 1) * (25 + 50)) / 2));

		println(10);

		int a = 10;
		int b = -35;

		println(myAbs(a));
		println(myAbs(b));

		makeCard("현규", 90, 87, 50);
		
		System.out.println("=========================================================");
		
		int age = 31;
		println(calGen(age));
		
	}

	public static void printSum(int a, int b) {
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println(a + " 부터 " + b + "까지 더한 값: " + sum);
	}

	public static void printSumNotFor(int start, int end) {
		int sum = ((Math.abs(end - start) + 1) * (start + end)) / 2;
		System.out.println(start + " 부터 " + end + "까지 더한 값: " + sum);
	}

	public static void println(String input) {
		System.out.println(input);
	}

	public static void println(int input) {
		System.out.println(input);
	}

	public static void println(double input) {
		System.out.println(input);
	}

	public static void print(String input) {
		System.out.print(input);
	}

	public static void print(int input) {
		System.out.print(input);
	}

	public static void print(double input) {
		System.out.print(input);
	}

	public static int myAbs(int input) {
		return (input > 0) ? (input) : (-input);
	}

	public static void makeCard(String name, int kor, int eng, int math) {
		println("==============================");
		println(name);
		println("국어: " + kor);
		println("영어: " + eng);
		println("수학: " + math);
		double avg = (kor + eng + math) / 3.0;
		avg = myRound(avg,2);
		println("평균: " + avg);
		if (avg > 90) {
			println("등급: A");
		} else if (avg > 80) {
			println("등급: B");
		} else {
			println("등급: C");
		}
		println("==============================");
	}

	/**
	 * @param num 반올림 하고자 하는 소수
	 * @param n   소수 n번째 자리까지 리턴
	 * @return    반올림된 소수 리턴
	 */
	public static double myRound(double num, int n) {
		return Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
	}
	
	public static int calGen(int age) {
		return (age/10) * 10;
	}
}

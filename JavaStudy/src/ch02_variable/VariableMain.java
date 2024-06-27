package ch02_variable;

public class VariableMain {

	// main 입력 후 ctrl + space : public static void main(String[] args) 완성
	public static void main(String[] args) {

		// 변수
		int money;

		money = 100000;

		System.out.println(money);

		money = 200000;

		System.out.println(money);

		// 상수
		final int AGE = 20;

		System.out.println(AGE);

		// age = 30; 불가능

		int number = 5;

		// 정수 타입
		byte byteNumber = 100; // 1바이트
		short shortNumber = 100; // 2바이트
		int intNumber = 1000000000; // 4바이트
		long longNumber = 100000000000L; // 8바이트, 숫자 뒤에 L을 붙여주어야 함.

		// 실수 타입
		float floatNumber = 13.45f; // 4바이트, 숫자 뒤에 f를 붙여주어야 함.
		double doubleNumber = 13.45; // 8바이트

		// 불리언 타입
		boolean isRun = true;
	}
}
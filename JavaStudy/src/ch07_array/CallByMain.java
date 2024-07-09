package ch07_array;

public class CallByMain {
	public static void main(String[] args) {
		int a = 10;
		int b = a;

		System.out.println(b);

		a = 20;
		System.out.println(b); // 기본타입에 대해서는 Call by Value 로 동작.

		ArrayMain2.swap(a, b);

		System.out.println("a = " + a);
		System.out.println("b = " + b); // 참조타입에 대해서는 Call by Reference 로 동작.

	}
}
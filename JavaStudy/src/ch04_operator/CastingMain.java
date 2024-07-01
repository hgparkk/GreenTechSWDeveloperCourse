package ch04_operator;

public class CastingMain {
	public static void main(String[] args) {
		int intNum = 15;

		int div = intNum / 2; // int/int 는 int 타입으로 반환.

		double doubNum = 1.23;

		System.out.println(intNum * doubNum); // int * 소수 or int / 소수 는 소수 타입으로 반환.

		System.out.println(intNum / 2.0); // 정수 뒤에 .0을 붙이면 소수타입으로 인식

		// int num = 20L; int 타입 변수에 long 값을 넣으려하면 에러가 발생함.
		long longNum = 20; // int 값을 long 타입으로 자동 형변환

		int num = (int) 20L; // long 값을 int 타입으로 강제 형변환
		System.out.println(num);

		num = (int) 3000000000L;
		System.out.println(num); // 담을 수 있는 범위를 초과하면 시작값으로 돌아간다.

		int intCast = (int) 3.45; // 소수타입 값 int 타입으로 강제 형변환
		System.out.println(intCast); // 소수부분 사라짐

		String strNum = "235";

		System.out.println(strNum + 2); // String + int 는 문자열 이어붙이기가 됨.
		int result = Integer.parseInt(strNum); // String 타입을 int로 형변환
		System.out.println(result + 2); // String + int 는 문자열 이어붙이기가 됨.
		
		String str = Integer.toString(235); // 정수 값 String 타입으로 형 변환.
		str = 235+""; // 위 Stirng + int 조건 때문에 자동으로 String 타입이 된다.
		
		double dNum = Double.parseDouble("34.56"); // String 타입을 double로 형변환
	}
}
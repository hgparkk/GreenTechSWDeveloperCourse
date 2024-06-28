package ch02_variable;

public class StringMain {
	public static void main(String[] args) {

		// 문자 타입
		char A = 65; // char 하나의 문자를 담는데 사용.

		System.out.println(A); // 유니코드 65는 A이다.

		char ga = '가'; // '가'에 대한 유니 코드인 44032 숫자가 저장됨.

		System.out.println(ga); // 표기는 유니 코드에 해당하는 문자가 보여진다.

		// 문자열 타입
		String fruits = "Apple, Banana, Cherry";
		System.out.println(fruits.length()); // 문자열의 길이를 반환.
		System.out.println(fruits.charAt(7)); // 인덱스 번호에 해당하는 문자를 반환.(char 타입)

		// subStirng(시작 인덱스, 끝 인덱스) : 해당 문자열을 시작 인덱스부터 끝 인덱스 전까지 반환.(String 타입)
		System.out.println(fruits.substring(0, 5));
		System.out.println(fruits.substring(7, 13));
		System.out.println(fruits.substring(15, 21));

		// substring(시작 인덱스) : 해당 문자열을 시작 인덱스부터 끝까지 반환.(String 타입)
		System.out.println(fruits.substring(7));

		// fruits.substring(99); // 존재하지 않는 인덱스 번호를 넣으면 에러가 발생함.

		System.out.println(fruits.replace("Apple", "Avocado")); // 해당 문자열에서 특정 문자열을 바꾼 결과를 반환.

		System.out.println(fruits); // 변수는 변하지 않는다.

		fruits = fruits.replace("Apple", "Avocado"); // 원본 문자열 교체하기.
		System.out.println(fruits);

		String example = "   Hello, Master !!  ";
		System.out.println(example.trim()); // 해당 문자열의 양 끝에 존재하는 모든 공백문자가 제거된 문자열을 반환.
		System.out.println(example.replace(" ", "")); // replace를 이용한 공백 제거.

		System.out.println(fruits.toUpperCase()); // 문자열을 모두 대문자로 바꾼 결과를 반환.
		System.out.println(fruits.toLowerCase()); // 문자열을 모두 소문자로 바꾼 결과를 반환.

		System.out.println(fruits.indexOf("Banana")); // 해당 문자열에서 괄호 안에 있는 문자열의 인덱스 번호 반환.
		System.out.println(fruits.indexOf("Orange")); // 존재하지 않는 문자열이면 -1 반환.
		System.out.println(fruits.indexOf("a")); // 대소문자를 구별하고 가장 앞에있는 문자열의 인덱스를 반환.

		System.out.println(fruits.contains("Banana")); // 해당 문자열 내부 괄호안 문자열이 존재하면 true, 존재하지 않으면 false 반환.
		System.out.println(fruits.contains("Orange"));

		System.out.println(fruits + ", Durian"); // 문자열 이어붙이기.
		fruits = fruits + ", Durian";
		System.out.println(fruits);

		// etc
		System.out.println("Mango, " + fruits);

		String strNull = null; // 참조타입의 경우 null 값을 가질 수 있다.
		System.out.println(strNull);

		String strEmpty = "";
		System.out.println(strEmpty);

		System.out.println(strNull.length()); // 에러가 발생함.
		System.out.println(strEmpty.length());
	}
}
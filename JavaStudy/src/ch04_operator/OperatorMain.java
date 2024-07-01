package ch04_operator;

public class OperatorMain {
	public static void main(String[] args) {
		int numA = 10;
		int numB = 3;

		System.out.println("=========================================================");

		// 산술 연산
		System.out.println(numA + 1);

		numA = numA + 1;

		System.out.println(numA);

		System.out.println("=========================================================");

		// 사칙 연산
		System.out.println(numA + numB);
		System.out.println(numA - numB);
		System.out.println(numA * numB);
		System.out.println(numA / numB);
		System.out.println(numA % numB);

		System.out.println("=========================================================");

		// 대입 연산
		numA = 10;

		numA += 5;
		System.out.println(numA);

		numA -= 10;
		System.out.println(numA);

		numA *= 3;
		System.out.println(numA);

		numA /= 7;
		System.out.println(numA);

		numA %= 3;
		System.out.println(numA);

		String station = "탄방역";
		station = station + " 용문역"; // 문자열에도 산술연산이 가능.
		station += " 오룡역"; // 문자열에도 대입연산이 가능.
		System.out.println(station);

		station = "시청역 " + station; // 문자열 앞에 붙이려면 산술연산 형태만 사용 가능.

		// station -= "오룡역" 문자열에 대한 연산은 + 만 가능.

		System.out.println("=========================================================");

		// 증감 연산
		numA = 10;

		numA++; // 변수에 1 더함.
		System.out.println(numA);

		numA--; // 변수에 1 뺌.
		System.out.println(numA);

		// 변수 앞에 붙여도 연산됨.
		++numA;
		System.out.println(numA);

		--numA;
		System.out.println(numA);

		// 하지만 실행 순서에 연관이 있다.
		System.out.println(numA++); // 출력 후에 증감 연산.
		System.out.println(++numA); // 출력 전에 증감 연산.

		System.out.println("=========================================================");

		// 비교 연산
		numA = 10;
		numB = 3;
		double pi = 3.14;

		System.out.println(numA > numB); // 맞다면 true 반환.
		System.out.println(numA < numB); // 틀리다면 faluse 반환.

		boolean isBig = numA > numB; // 비교 연산의 결과를 불리언 값을 반환한다.
		System.out.println(isBig);

		System.out.println(numB > pi); // 타입이 다른 숫자에 대해서도 비교 연산 가능.

		System.out.println(numA == numB); // 숫자가 서로 같은지
		System.out.println(numA != numB); // 숫자가 서로 다른지

		String ship = "배";
		String pear = "배";

		System.out.println(ship == pear);

		String wordA = "기대";
		String wordB = "대나무";

		// 올바르지 않은 문자열 비교
		System.out.println(wordA.substring(1));
		System.out.println(wordB.substring(0, 1));
		System.out.println(wordA.substring(1) == wordB.substring(0, 1));

		String stomach = new String("배");
		System.out.println(stomach);
		System.out.println(ship == stomach);
		System.out.println(pear == stomach);

		// 올바른 문자열 비교
		System.out.println(ship.equals(stomach));

		String input = "";
		// 빈 문자열을 체크하는 여러가지 방법
		System.out.println(input.equals(""));
		System.out.println(input.length() == 0);
		System.out.println(input.isEmpty());

		String id = "a001";

		String check = (id.length() > 7) ? ("통과") : ("불통"); // 삼항 연산자를 이용한 문자열 길이가 7글자 이상인지 체크
		System.out.println(check);

		// score가 90 이상이면 A, 아니면 B를 grade에 담기
		int score = 95;

		String grade = (score >= 90) ? "A" : "B";

		// score가 90 이상이면 A, 80점 이상이면 B, 아니면 C를 grade에 담기
		grade = (score >= 90) ? ("A") : ((score >= 80) ? ("B") : ("C"));

		System.out.println("=========================================================");

		// 회원가입 예제
		String inputName = "박현규"; // 이름은 한글자 이상
		int inputAge = 15; // 나이는 14세 이상
		String inputPhone = "01030856082"; // 휴대폰번호는 10자리 또는 11자리

		System.out.println(inputName.length() >= 1);
		System.out.println(inputName.length() > 0);

		System.out.println(inputAge >= 14);

		System.out.println((inputPhone.length() == 10 || inputPhone.length() == 11));
		System.out.println(10 <= inputPhone.length() && inputPhone.length() <= 11);

		System.out.println(inputName.isEmpty());
		System.out.println(!inputName.isEmpty());

		boolean nameCheck = !inputName.isEmpty();
		boolean ageCheck = inputAge >= 14;
		boolean phoneCheck = (inputPhone.length() == 10 || inputPhone.length() == 11);

		System.out.println(nameCheck && ageCheck && phoneCheck);
		System.out.println(
				!inputName.isEmpty() && inputAge > 14 && inputPhone.length() == 10 || inputPhone.length() == 11);
		System.out.println(
				!inputName.isEmpty() && inputAge > 14 && (inputPhone.length() == 10 || inputPhone.length() == 11));

		System.out.println("=========================================================");

		// 비트 연산자
		
		int ten = 10;
		int nine = 9;
		
		System.out.println(ten & nine); // 1010 과 1001 을 각 비트마다 and 연산
		
		System.out.println(ten|nine); // 1010 과 1001 을 각 비트마다 or 연산
		
		System.out.println(ten^nine); // 1010 과 1001 을 각 비트마다 xor 연산
	}
}
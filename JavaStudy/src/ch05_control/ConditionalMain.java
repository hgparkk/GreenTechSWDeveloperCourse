package ch05_control;

public class ConditionalMain {
	public static void main(String[] args) {
		int price = 30000;
		int money = 10000;

		if (money < price) {
			System.out.println("잔액이 부족합니다."); // () 안 조건이 참이면 {} 내용을 실행, 거짓이면 실행하지 않음.
		}

		if (money < price)
			System.out.println("잔액이 부족합니다."); // {} 코드가 한줄이면 {} 생략 가능
		System.out.println("조건문 밖"); // {}를 생략하고 코드를 한 줄 더 썼을 때 조건문 밖 코드이기 때문에 실행됨.

		System.out.println("=========================================================");

		String review = "맛있어요.";

		if (review.length() < 10) {
			String warning = "리뷰는 10글자 이상 작성해주세요.";
		}

		// System.out.println(warning); 변수의 사용 범위는 {} 안 이다.

		String warning = "";
		if (review.length() < 10) {
			warning = "리뷰는 10글자 이상 작성해주세요."; // {} 안에서 사용하기 전 {} 밖에 미리 선언
		}

		System.out.println(warning);

		warning = (review.length() < 10) ? ("리뷰는 10글자 이상 작성해주세요.") : ("통과");

		System.out.println(warning);

		System.out.println("=========================================================");

		money = 100000;
		price = 30000;

		if (money < price) {
			System.out.println("잔액이 부족합니다.");
		} else {
			System.out.println("물품이 구매되었습니다."); // () 안 조건이 거짓이면 else {} 내용 실행.
		}

		warning = "";
		if (review.length() < 10) {
			warning = "리뷰는 10글자 이상 작성해주세요.";
		} else {
			warning = "통과";
		}

		System.out.println(warning);

		String idBack = "12345678";

		if (Integer.parseInt(idBack.substring(0, 1)) % 2 == 0) {
			System.out.println("여성");
		} else {
			System.out.println("남성");
		}

		boolean isPowerOn = false;
		if (isPowerOn == false) {
			System.out.println("TV를 켠다.");
			isPowerOn = true;
		} else {
			System.out.println("TV를 끈다.");
			isPowerOn = false;
		}

		if (isPowerOn) {
			System.out.println("TV를 끈다.");
			isPowerOn = true;
		} else {
			System.out.println("TV를 켠다.");
			isPowerOn = false;
		}

		if (!isPowerOn) {
			System.out.println("TV를 켠다.");
			isPowerOn = true;
		} else {
			System.out.println("TV를 끈다.");
			isPowerOn = false;
		}

		if (!isPowerOn) {
			System.out.println("TV를 켠다.");
		} else {
			System.out.println("TV를 끈다.");
		}
		isPowerOn = !isPowerOn;

		System.out.println("=========================================================");

		int inputAge = 23;

		if (inputAge >= 10 && inputAge < 20) {
			System.out.println("노란티");
		} else if (inputAge >= 20 && inputAge < 30) {
			System.out.println("흰티");
		} else if (inputAge >= 30 && inputAge < 40) {
			System.out.println("초록티");
		} else if (inputAge >= 40 && inputAge < 50) {
			System.out.println("파란티");
		} else {
			System.out.println("빨간티");
		}

		int score = 95;

		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80 && score < 90) {
			System.out.println("B");
		} else if (score >= 70 && score < 80) {
			System.out.println("C");
		} else {
			System.out.println("D");
		}

		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else {
			System.out.println("D");
		}

		if (score >= 70) {
			System.out.println("C");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("A");
		} else {
			System.out.println("D");
		}

		System.out.println("=========================================================");

		// 회원가입 예제
		String name = "박현규"; // 이름은 한글자 이상
		int age = 20; // 나이는 14세 이상
		String phone = "01030856082"; // 휴대폰번호는 10자리 또는 11자리

		if (name.length() > 0) {
			if (age >= 14) {
				if (phone.length() == 10 || phone.length() == 11) {
					System.out.println("통과");
				} else {
					System.out.println("불통");
				}
			} else {
				System.out.println("불통");
			}
		} else {
			System.out.println("불통");
		}

		if (name.length() > 0 && age >= 14 && (phone.length() == 10 || phone.length() == 11)) {
			System.out.println("통과");
		} else {
			System.out.println("불통");
		}
		
		int month = 4;
		switch(month) {
			case 0:
				System.out.println("자바 수업");
				break;
			case 1:
				System.out.println("DB 수업");
				break;
			case 2:
				System.out.println("HTML/CSS/JS 수업");
				break;
			case 3:
				System.out.println("스피링 수업");
				break;
			case 4:
				System.out.println("파이썬 수업");
				break;
			case 5:
				System.out.println("미니 팀프로젝트");
				break;
			default:
				System.out.println("팀프로젝트");
		}
	}
}

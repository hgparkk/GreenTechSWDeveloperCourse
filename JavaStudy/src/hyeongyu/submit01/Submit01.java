package hyeongyu.submit01;

public class Submit01 {
	public static void main(String[] args) {

		// Q. 01
		// 변수 선언
		String name = "홍길동";
		int age = 26;
		double height = 187.9;
		String phone = "01073987332";
		String email = "akow283@gmail.com";

		// 출력
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("키: " + height);
		System.out.println("연락처: " + phone);
		System.out.println("이메일: " + email);

		System.out.println();

		// Q. 02
		String enigma = "너오구늘리뭐너먹구지리";
		enigma = enigma.replace("너", "");
		System.out.println("1차 암호 해독[너 제거]: " + enigma);
		enigma = enigma.replace("구", "");
		System.out.println("2차 암호 해독[구 제거]: " + enigma);
		enigma = enigma.replace("리", "");
		System.out.println("3차 암호 해독[리 제거]: " + enigma);
		System.out.println("해독완료!! ->" + enigma);
		System.out.println(enigma);

		System.out.println();

		// Q. 03
		// 변수 선언
		String wordA = "기대";
		String wordB = "대나무";
		String wordC = "무릉도원";

		// 첫번째 글자 출력
		System.out.println(wordA.substring(0, 1));
		System.out.println(wordB.substring(0, 1));
		System.out.println(wordC.substring(0, 1));

		// 마지막 글자 출력
		System.out.println(wordA.substring(wordA.length() - 1));
		System.out.println(wordB.substring(wordB.length() - 1));
		System.out.println(wordC.substring(wordC.length() - 1));
	}
}
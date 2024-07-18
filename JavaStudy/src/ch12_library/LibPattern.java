package ch12_library;

public class LibPattern {
	public static void main(String[] args) {
		// 유효성 검증 (Validation)
		String example = "123123";

		String regex = "^[0-9]+$"; // ^ : 문자열의 시작, $ : 문자열의 끝 [] : 하나의 문자, [0-9] 하나의 숫자, + : 1개 이상, * : 0개 이상

		System.out.println(example.matches(regex));

		example = "Park Hyeon Gyu";

		regex = "^[A-Za-z ]+$"; // [A-Z] : 하나의 영어 대문자, [a-z] : 하나의 영어 소문자, \\s : 공백

		System.out.println(example.matches(regex));

		example = "문국태";

		regex = "^[가-힣ㄱ-ㅎㅏ-ㅣ]+$"; // [가-힣] : 하나의 한글 문자, [ㄱ-ㅎ] : 하나의 한글 자음, [ㅏ-ㅣ] : 하나의 한글 모음

		System.out.println(example.matches(regex));

		example = "phg2559";

		regex = "^[\\w]{7,12}$"; // \\w : [A-Za-z0-9]와 같음, {a} : a 번 반복, {a,} : a 번 반복 이상, {a,b} : a 번 반복 이상 b 번
									// 반복 이하

		System.out.println(example.matches(regex));

		example = "1q2w3e4r!";

		regex = "^[\\w!@#$%^&*]+$"; // !@#$%^&* : 특수문자

		System.out.println(example.matches(regex));

		example = "1Q2w3e4r!";

		regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[\\w!@#$%^&*]+$"; // 비밀번호 형식 = 영어 대문자, 영어 소문자, 대문자,
																						// 숫자, 특수문자 각각 1개 이상, 8~14 글자,
																						// . : 임의의 문자,
																						// (?=.*[]) : [] 안 문자 포함 여부

		System.out.println(example.matches(regex));
		
		example = "phg2559@naver.com";
		
		regex = "^[\\w]+[@][\\w]+[.][\\w]+$";
		
		System.out.println(example.matches(regex));
		
		example = "1233314";
		
		regex = "^.*([0-9])\\1\\1.*$"; // 연속되는 세 숫자
		
		System.out.println(example.matches(regex));
	}
}
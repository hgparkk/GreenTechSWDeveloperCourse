package ch03_system;

import java.util.Scanner;

public class SystemMain {
	public static void main(String[] args) {
		/**
		 * Java Doc 주석 메소드 선언부 상단에 메소드에 대한 설명을 적는데 사용
		 */

		// TODO 주석
		// Window - Show View - Tasks 에서 TODO 주석 위치 확인 가능

		System.out.print(1); // 줄바꿈 하지 않고 괄호 안 내용 콘솔창에 입력

		// 제어문자
		System.out.print("\n"); // \n 개행문자(줄바꿈)
		System.out.print("\t"); // \t 탭문자
		System.out.println("\\,\",\'"); // \ + \,",' 그 문자 그 자체

		// System.out.printf 포맷 문자열과 함께 사용
		System.out.printf("포맷 문자열 없이 씀 \n");
		System.out.printf("총 인원은 %d 입니다. \n", 24);
		System.out.printf("오늘은 %d월 %d일 입니다. \n", 6, 28);
		System.out.printf("8월 15일은 %s입니다. \n","광복절 \n");
		System.out.printf("ch%02d장 \n",5); //강제 두자리 숫자
		System.out.printf("%.2f \n", 3.141592); //소수점 둘째자리까지
		System.out.printf("보유금액: %,d \n",1000000);
		
		//표준 입력
		// Scanner 사용
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요");
		System.out.print(">>> ");
		String inputName = scan.nextLine();
		
		System.out.println(inputName + "님 환영합니다.");
		
		System.out.print("나이를 입력해주세요: ");
		String inputAge = scan.nextLine();
		System.out.printf("나이: %s세", inputAge);
	}
}
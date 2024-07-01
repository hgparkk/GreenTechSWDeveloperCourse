package hyeongyu.submit02;

import java.util.Scanner;

public class Submit02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Q. 01
		System.out.println("이름을 입력해주세요.");
		System.out.print(">>> ");
		String name = scan.nextLine();

		System.out.println("국어 점수를 입력해주세요.");
		System.out.print(">>> ");
		int kor = Integer.parseInt(scan.nextLine());

		System.out.println("영어 점수를 입력해주세요.");
		System.out.print(">>> ");
		int eng = Integer.parseInt(scan.nextLine());

		System.out.println("수학 점수를 입력해주세요.");
		System.out.print(">>> ");
		int math = Integer.parseInt(scan.nextLine());

		double avg = (kor + eng + math) / 3.0;

		System.out.println("이름: " + name);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.printf("평균: %.2f \n", avg);

		System.out.println();

		// Q. 02
		int example = 278;

		String exampleStr = example + "";

		int hundred = Integer.parseInt(exampleStr.substring(0, 1));
		int ten = Integer.parseInt(exampleStr.substring(1, 2));
		int one = Integer.parseInt(exampleStr.substring(2, 3));

		System.out.println("결과는 : " + (hundred + ten + one));

		//다른 방법
		System.out.println("결과는 : " + ((example / 100) + (example % 100 / 10) + (example % 10)));
	}
}
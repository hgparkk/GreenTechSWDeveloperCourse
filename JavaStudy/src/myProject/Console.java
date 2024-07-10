package myProject;

import java.util.Scanner;

public class Console {
	static Scanner scan = new Scanner(System.in);

	//콘솔창에 화면 지우기
	public static void clear() {
		for (int i = 0; i < 80; i++) {
			System.out.println();
		}
	}

	//게임을 시작할때 입력을 받아 시작하기 위한 함수
	public static void start() {
		scan.nextLine();
	}

	//사용자가 입력한 답안을 반환하는 함수
	public static int[] answer() {
		System.out.println("다음 좌표 입력 (x,y 식 왼쪽 위부터 1,1 ~ 오른쪽 아래까지 10,10)");
		System.out.print(">>> ");
		String input = scan.nextLine();
		String[] result = input.split(",");
		//값을 정확히 입력하지 않았을 때
		if (result.length != 2) {
			System.out.println("잘못된 입력입니다.");
			return answer();
		} else {
			int[] resultInt = new int[2];
			for (int i = 0; i < resultInt.length; i++) {
				//좌표에 범위를 넘는 좌표를 입력했을 때
				if (Integer.parseInt(result[i]) < 1 || 10 < Integer.parseInt(result[i])) {
					System.out.println("올바르지 않은 입력입니다.");
					return answer();
				} else {
					resultInt[i] = (Integer.parseInt(result[i]) - 1);
				}
			}
			return resultInt;
		}
	}
}

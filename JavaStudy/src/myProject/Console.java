package myProject;

import java.util.Scanner;

public class Console {
	static Scanner scan = new Scanner(System.in);

	public static void clear() {
		for (int i = 0; i < 80; i++) {
			System.out.println();
		}
	}

	public static void start() {
		scan.nextLine();
	}

	public static String reStart() {
		String result = scan.nextLine();
		return result;
	}

	public static int[] answer() {
		System.out.println("다음 좌표 입력 (x,y 식 왼쪽 위부터 1,1 ~ 오른쪽 아래까지 10,10)");
		System.out.print(">>> ");
		String input = scan.nextLine();
		String[] result = input.split(",");
		if (result.length != 2) {
			System.out.println("잘못된 입력입니다.");
			return answer();
		} else {
			int[] resultInt = new int[2];
			for (int i = 0; i < resultInt.length; i++) {
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

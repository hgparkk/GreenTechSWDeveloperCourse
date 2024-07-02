package hyeongyu.submit04;

import java.util.Scanner;

public class Submit04 {
	public static void main(String[] args) {

		// Q. 01
		int ranNum = (int) ((Math.random() * 49) + 1);

		Scanner scan = new Scanner(System.in);
		int peekNum = 0;
		int count = 5;
		while (count > 0) {
			System.out.print("숫자를 입력해주세요 : ");
			peekNum = Integer.parseInt(scan.nextLine());
			if (peekNum == ranNum) {
				System.out.println("정답입니다.");
				break;
			} else if (count == 1) {
				System.out.println("실패하였습니다. 정답은 " + ranNum + "입니다.");
			} else if (peekNum > ranNum) {
				System.out.println("다운!! 기회가 " + (count - 1) + "번 남았습니다.");
			} else if (peekNum < ranNum) {
				System.out.println("업!! 기회가 " + (count - 1) + "번 남았습니다.");
			}
			count--;
		}

		System.out.println();

		// Q. 02
		System.out.print("거꾸로 뒤집을 문자열 입력 : ");
		String word = scan.nextLine();
		String result = "";
		int round = word.length();
		while (round > 0) {
			result += word.substring(round - 1, round);
			round--;
		}
		System.out.println(result);
	}
}

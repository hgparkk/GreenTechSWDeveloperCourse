package ch05_control;

import java.util.Scanner;

public class LoopWhileMain {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}

		boolean isRun = true;
		Scanner scan = new Scanner(System.in);

		String cart = "";
		while (isRun) {
			System.out.println("물품 입력[종료:q] : ");
			String name = scan.nextLine();

			if (name.equals("q")) {
				isRun = false;
			}

			cart += name;
			System.out.println("장바구니: " + cart);
		}

		cart = "";
		while (true) {
			System.out.println("물품 입력[종료:q] : ");
			String name = scan.nextLine();

			if (name.equals("q")) {
				break;
			}

			cart += name;
			System.out.println("장바구니: " + cart);
		}

		System.out.println("=========================================================");

		int hp = 100;
		outer: while (true) {
			System.out.println("야생의 파이리를 만났습니다.");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 공격 | 2. 도망");
			System.out.print(">>> ");

			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				System.out.println("공격!");
				while (true) {
					System.out.println("공격 방법 선택");
					System.out.println("1. 백만볼트 | 2. 전광석화 | 3. 취소");
					System.out.print(">>> ");

					int attack = Integer.parseInt(scan.nextLine());

					if (attack == 1) {
						System.out.println("피카츄 백만볼트!");
						hp -= 40;
					} else if (attack == 2) {
						System.out.println("전광석화");
						hp -= 20;
					} else if (attack == 3) {
						System.out.println("공격 취소");
						break;
					}

					System.out.println("파이리의 현재 체력" + hp);

					if (hp <= 0) {
						System.out.println("파이리를 잡았다!");
						break outer; // outer: 로 이름을 붙인 while문에 대해 break 문을 실행할 수 있다.
					}
				}
			} else if (command == 2) {
				System.out.println("도망쳤습니다.");
				break;
			}
		}
	}
}
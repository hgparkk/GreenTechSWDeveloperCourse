package ch06_method;

import java.util.Scanner;

public class MethodMain2 {
	public static void main(String[] args) {
		recursionPrint(10);

		playPokemon();
	}

	public static void recursionPrint(int n) {
		System.out.println(n);
		if (n == 1) {
			return;
		}
		recursionPrint(n - 1);
	}

	public static void playPokemon() {
		Scanner scan = new Scanner(System.in);

		System.out.println("========================================================");

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
						return;
					}
				}
			} else if (command == 2) {
				System.out.println("도망쳤습니다.");
				break;
			}
		}
	}
}
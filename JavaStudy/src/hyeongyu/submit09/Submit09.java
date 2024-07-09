package hyeongyu.submit09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Submit09 {
	public static void main(String[] args) {

		// Q. 01
		Product fridge = new Product("냉장고", 2000000);
		Product TV = new Product("TV", 1000000);
		Product aircon = new Product("에어컨", 800000);
		Product computer = new Product("컴퓨터", 1300000);
		Product fan = new Product("선풍기", 100000);

		ArrayList<Product> productList = new ArrayList<>();

		productList.add(fridge);
		productList.add(TV);
		productList.add(aircon);
		productList.add(computer);
		productList.add(fan);

		Collections.sort(productList, (product1, product2) -> product1.getPrice() - product2.getPrice());

		for (Product p : productList) {
			System.out.println(p);
		}

		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getName().equals("TV")) {
				System.out.println(i);
			}
		}

		// etc
		int myMoney = 1000000;

		ArrayList<Product> canBuyList = new ArrayList<>();
		for (Product p : productList) {
			if (p.getPrice() < myMoney) {
				canBuyList.add(p);
			}
		}

		for (Product p : canBuyList) {
			System.out.println(p);
		}

		// Q. 02
		ArrayList<Fish> fishList = new ArrayList<>();

		fishList.add(new Fish("고등어", 5000));
		fishList.add(new Fish("광어", 25000));
		fishList.add(new Fish("우럭", 27000));
		fishList.add(new Fish("참돔", 30000));
		fishList.add(new Fish("돌돔", 35000));
		fishList.add(new Fish("능성어", 70000));
		fishList.add(new Fish("다금바리", 120000));

		Scanner scan = new Scanner(System.in);

		ArrayList<Fish> fishBag = new ArrayList<>();

		int bait = 10;
		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 낚시하기 | 2. 잡은 물고기 목록 | 3. 떠나기");
			System.out.print(">>> ");

			int select = Integer.parseInt(scan.nextLine());

			if (select == 1) {
				if (bait > 0) {
					int rate = (int) (Math.random() * 100);
					int index = -1;
					if (rate < 25) {
						index = 0;
					} else if (rate < 40) {
						index = 1;
					} else if (rate < 55) {
						index = 2;
					} else if (rate < 70) {
						index = 3;
					} else if (rate < 85) {
						index = 4;
					} else if (rate < 95) {
						index = 5;
					} else {
						index = 6;
					}
					fishBag.add(fishList.get(index));
					System.out.println(fishList.get(index).getName() + "을 잡았다!!");
					bait--;
					System.out.println("현재 미끼의 개수 : " + bait);
				} else {
					System.out.println("미끼가 부족합니다.");
				}
			} else if (select == 2) {
				System.out.println("내 가방 ==========");
				int sum = 0;
				for (Fish f : fishBag) {
					System.out.println(f);
					sum += f.getPrice();
				}
				System.out.println("총 " + sum + "원 ==========");
			} else if (select == 3) {
				break;
			}
			System.out.println();
		}
	}
}
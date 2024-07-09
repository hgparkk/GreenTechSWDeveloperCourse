package hyeongyu.submit07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Submit07 {
	public static void main(String[] args) {

		// Q. 01
		ArrayList<Integer> randIntList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			randIntList.add((int) ((Math.random() * 11) + 10));
		}

		System.out.println(randIntList);

		ArrayList<Integer> notDupRandIntList = new ArrayList<>();
		for (int i = 0; i < randIntList.size(); i++) {
			if (i == 0) {
				notDupRandIntList.add(randIntList.get(i));
			} else {
				boolean isContain = false;
				for (int j = 0; j < notDupRandIntList.size(); j++) {
					if (notDupRandIntList.get(j) == randIntList.get(i)) {
						isContain = true;
					}
				}
				if (!isContain) {
					notDupRandIntList.add(randIntList.get(i));
				}
			}
		}

		System.out.println(notDupRandIntList);

		// 다른 방법 1
		notDupRandIntList.clear();

		for (int i = 0; i < randIntList.size(); i++) {
			if (!notDupRandIntList.contains(randIntList.get(i))) {
				notDupRandIntList.add(randIntList.get(i));
			}
		}

		System.out.println(notDupRandIntList);

		// 다른 방법 2
		for (int i = 0; i < randIntList.size(); i++) {
			for (int k = randIntList.size() - 1; k > i; k--) {
				if (randIntList.get(i) == randIntList.get(k)) {
					randIntList.remove(k);
				}
			}
		}

		System.out.println(randIntList);

		Collections.sort(notDupRandIntList);

		System.out.println(notDupRandIntList);

		Collections.sort(notDupRandIntList, Collections.reverseOrder());

		System.out.println(notDupRandIntList);

		// Q. 02
		ArrayList<String> wifeWishList = new ArrayList<>(Arrays.asList("냉장고", "로봇청소기", "세탁기", "에어컨"));
		ArrayList<String> husbandWishList = new ArrayList<>(Arrays.asList("노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"));
		ArrayList<String> bothWishList = new ArrayList<>();

		for (int i = 0; i < husbandWishList.size(); i++) {
			if (wifeWishList.contains(husbandWishList.get(i))) {
				bothWishList.add(husbandWishList.get(i));
			}
		}

		System.out.println(bothWishList);

		ArrayList<String> allWishList = new ArrayList<>(wifeWishList);
		for (int i = 0; i < husbandWishList.size(); i++) {
			for (int j = 0; j < allWishList.size(); j++) {
				if (!allWishList.contains(husbandWishList.get(i))) {
					allWishList.add(husbandWishList.get(i));
				}
			}
		}

		System.out.println(allWishList);
	}
}
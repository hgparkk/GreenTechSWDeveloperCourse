package hyeongyu.submit06;

import java.util.Arrays;

public class Submit06 {

	// Q. 03
	public static int[] makeLotto() {
		int[] result = new int[6];
		int count = 0;
		while (count < 6) {
			int current = (int) ((Math.random() * 45) + 1);
			boolean isDuplicate = false;
			for (int j = 0; j < count; j++) {
				if (result[j] == current) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				result[count] = current;
				count++;
			}
		}
		Arrays.sort(result);
		return result;
	}

	public static void main(String[] args) {

		// Q. 01
		String[] nameArray = { "이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민",
				"최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬" };

		int count = 0;
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].substring(0, 1).equals("이")) {
				count++;
			}
		}
		System.out.println("이씨 성을 가진 배우가 총 " + count + "명 있습니다.");

		System.out.println();

		// Q. 02
		int[] intArr = { 23, 456, 213, 32, 464, 1, 2, 4 };
		int max = 0;
		int maxIndex = -1;
		int min = 0;
		int minIndex = -1;
		for (int i = 0; i < intArr.length; i++) {
			if (i == 0) {
				max = intArr[i];
				maxIndex = i;
				min = intArr[i];
				minIndex = i;
			} else {
				if (max < intArr[i]) {
					max = intArr[i];
					maxIndex = i;
				}
				if (min > intArr[i]) {
					min = intArr[i];
					minIndex = i;
				}
			}
		}
		System.out.println("최댓값: " + max);
		System.out.println("최댓값 인덱스: " + maxIndex);
		System.out.println("최솟값: " + min);
		System.out.println("최솟값 인덱스: " + minIndex);

		System.out.println();

		// Q. 03
		int[] myLotto = makeLotto();
		for (int i = 0; i < myLotto.length; i++) {
			System.out.print(myLotto[i] + " ");
		}
		System.out.println();

		System.out.println();

		int[] winLotto = { 4, 5, 8, 11, 37, 40 };

		int winCount = 0;
		boolean win = false;
		while (!win) {
			int[] lotto = makeLotto();
			winCount++;
			win = Arrays.equals(lotto, winLotto);
		}
		System.out.println(winCount + "번 만에 당첨!");
	}
}
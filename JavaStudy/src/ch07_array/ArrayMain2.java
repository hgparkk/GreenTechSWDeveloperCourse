package ch07_array;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class ArrayMain2 {
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	} // 제대로 작동하지 않는다.

	public static void swap(int[] intArray, int idxA, int idxB) {
		int temp = intArray[idxA];
		intArray[idxA] = intArray[idxB];
		intArray[idxB] = temp;
	} // Call by Reference를 고려한 swap 함수

	public static void main(String[] args) {
		String[] seoyugi = new String[4];

		seoyugi[0] = "삼장";
		seoyugi[1] = "오공";
		seoyugi[2] = "사오정";
		seoyugi[3] = "저팔계";

		ArrayMain.printArray(seoyugi);

		String[] sinSeoyugi = seoyugi; // sinSeoyugi 와 seoyugi 는 같은 주소를 가리킨다

		ArrayMain.printArray(sinSeoyugi);

		sinSeoyugi[0] = "강호동";
		sinSeoyugi[1] = "이수근";

		ArrayMain.printArray(sinSeoyugi);
		ArrayMain.printArray(seoyugi); // sinSeoyugi의 값을 바꾸었을 때 seoyugi도 같은 주소를 가리키기 때문에 seoyugi를 확인해도 값이 바뀐다.

		System.out.println(seoyugi.hashCode());
		System.out.println(sinSeoyugi.hashCode());

		System.out.println(seoyugi);
		System.out.println(Integer.toHexString(seoyugi.hashCode())); // 주소값이 일치

		// 해쉬코드 hashCode : 객체의 메모리 주소값을 이용해서 해쉬를 적용한 코드
		// 해쉬 hash : 해쉬함수(암호화 알고리즘)를 이용해서 데이터를 알호화하는 기법

		Encoder base64Encoder = Base64.getEncoder();
		String password = "1q2w3e4";
		byte[] encodedPassword = base64Encoder.encode(password.getBytes());
		System.out.println(new String(encodedPassword)); // base64로 encoding 된 문자열

		Decoder base64Decoder = Base64.getDecoder();
		System.out.println(new String(base64Decoder.decode(encodedPassword))); // decoding

		System.out.println("========================================================");

		String[] synSeoyugi = seoyugi.clone();

		ArrayMain.printArray(seoyugi);
		ArrayMain.printArray(synSeoyugi);

		synSeoyugi[2] = "은지원";

		ArrayMain.printArray(seoyugi);
		ArrayMain.printArray(synSeoyugi); // seoyugi와 sysSeoyugi 는 다른 주소를 가리킨다.

		System.out.println(seoyugi);
		System.out.println(synSeoyugi);

		System.out.println(seoyugi.hashCode());
		System.out.println(synSeoyugi.hashCode());

		String[] newSeoyugi = new String[seoyugi.length];
		for (int i = 0; i < seoyugi.length; i++) {
			newSeoyugi[i] = seoyugi[i];
		}

		ArrayMain.printArray(newSeoyugi);

		System.out.println("========================================================");

		int[] numArray = { 23, 456, 213, 32, 464, 1, 2 };

		int temp = numArray[0];
		numArray[0] = numArray[1];
		numArray[1] = temp;

		ArrayMain.printArray(numArray);

		swap(numArray, 2, 6);

		ArrayMain.printArray(numArray);

		System.out.println("========================================================");

		for (int k = 0; k < numArray.length - 1; k++) {
			for (int i = 0; i < numArray.length - k - 1; i++) {
				if (numArray[i] > numArray[i + 1]) {
					swap(numArray, i, i + 1);
				}
			}
		}
		ArrayMain.printArray(numArray); // 오름차순 정렬

		for (int k = 0; k < numArray.length - 1; k++) {
			for (int i = 0; i < numArray.length - k - 1; i++) {
				if (numArray[i] < numArray[i + 1]) {
					swap(numArray, i, i + 1);
				}
			}
		}
		ArrayMain.printArray(numArray); // 내림차순 정렬

		Arrays.sort(numArray);

		ArrayMain.printArray(numArray);

		for (int i = 0; i < numArray.length; i++) {
			numArray[i] *= -1;
		}
		Arrays.sort(numArray);
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] *= -1;
		} // 내림차순 정렬은 이런식으로 할 수 있다.

		ArrayMain.printArray(numArray);

		System.out.println("========================================================");

		int[] lottoOne = { 1, 4, 7, 12, 23, 43 };

		int[][] lottoTwo = { { 1, 4, 7, 12, 23, 43 }, { 2, 4, 7, 12, 24, 43 }, { 3, 4, 7, 12, 23, 43 },
				{ 4, 5, 7, 21, 23, 43 }, { 5, 6, 7, 12, 23, 43 } }; // 이차원 배열
		int[] lotto = lottoTwo[1];

		ArrayMain.printArray(lotto);

		System.out.println(lottoTwo[1][4]);
		System.out.println(lottoTwo[3][3]);

		int[][][] lottoThree = {
				{ { 1, 4, 7, 12, 23, 43 }, { 2, 4, 7, 12, 24, 43 }, { 3, 4, 7, 12, 23, 43 }, { 4, 5, 7, 21, 23, 43 },
						{ 5, 6, 7, 12, 23, 43 } },
				{ { 1, 4, 7, 12, 23, 43 }, { 2, 4, 7, 12, 24, 43 }, { 3, 4, 7, 12, 23, 45 }, { 4, 5, 7, 21, 23, 43 },
						{ 5, 6, 7, 12, 23, 43 } },
				{ { 1, 4, 7, 12, 23, 43 }, { 2, 4, 7, 12, 24, 43 }, { 3, 4, 7, 12, 23, 43 }, { 4, 5, 7, 21, 23, 43 },
						{ 5, 6, 7, 12, 23, 43 } } };

		System.out.println(lottoThree[1][2][5]);

		int[][] image2D = { { 1, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 }, { 1, 0, 0, 0, 0, 0, 1 } };

		int[] image1D = new int[49];

		int index = 0;
		for (int i = 0; i < image2D.length; i++) {
			for (int j = 0; j < image2D[i].length; j++) {
				image1D[index] = image2D[i][j];
				index++;
			}
		}

		ArrayMain.printArray(image1D);
	}
}
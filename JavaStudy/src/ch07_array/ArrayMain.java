package ch07_array;

public class ArrayMain {
	public static void printArray(String[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}

	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {
		String[] seoyugi = new String[4];

		System.out.println(seoyugi.length); // 배열의 크기 확인

		System.out.println(seoyugi); //

		System.out.println(seoyugi[0]); //

		seoyugi[0] = "삼장";
		seoyugi[1] = "오공";
		seoyugi[2] = "사오정";

		// seoyugi[3] = 4 다른 타입의 값을 담을 수 없음
		seoyugi[3] = "저팔계";
		// seoyugi[4] = "우마왕"; 존재하지 않은 인덱스

		for (int i = 0; i < seoyugi.length; i++) {
			System.out.println(seoyugi[i]);
		}

		printArray(seoyugi);

		System.out.println("=========================================================");

		for (int i = 0; i < seoyugi.length; i++) {
			seoyugi[i] = "서유기 " + seoyugi[i];
		}

		printArray(seoyugi);

		for (int i = 0; i < seoyugi.length; i++) {
			if (seoyugi[i].contains("오공")) {
				seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");
			}
		}

		printArray(seoyugi);

		int findIndex = -1;
		for (int i = 0; i < seoyugi.length; i++) {
			if (seoyugi[i].contains("사오정")) {
				findIndex = i;
			}
		}

		System.out.println(findIndex);
		System.out.println(seoyugi[findIndex]);

		for (int i = 0; i < seoyugi.length; i++) {
			if (seoyugi[i].indexOf("사오정") != -1) {
				findIndex = i;
			}
		}

		System.out.println(findIndex);
		System.out.println(seoyugi[findIndex]);

		System.out.println("=========================================================");

		int[] intArray = new int[6];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;
		intArray[5] = 6;

		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) ((Math.random() * 45) + 1);
		}

		printArray(intArray);

		int[] numArray = { 1, 2, 3, 4, 5, 6 };

		printArray(numArray);

		System.out.println(numArray[2]);

		System.out.println("=========================================================");

		String books = "이것이 자바다, 에너지 데이터 경영론, 파이썬";
		String[] bookArray = books.split(",");
		printArray(bookArray);

		for (int i = 0; i < bookArray.length; i++) {
			bookArray[i] = bookArray[i].trim();
		}

		printArray(bookArray);

		String calStr = "1+4+2";
		String[] calArray = calStr.split("\\+"); // *, ?, + 의 경우 정규표현식에서 특정 의미를 가지는 문자이므로 이 문자를 일반 문자로 쓰려면 앞에 //를 붙인다.
		printArray(calArray);

	}
}
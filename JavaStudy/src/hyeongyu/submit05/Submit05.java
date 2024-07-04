package hyeongyu.submit05;

public class Submit05 {

	// Q. 01
	public static void makeTree(int n) {
		for (int i = 0; i < n; i++) {
			String stars = "";
			for (int j = 0; j < n + i; j++) {
				if ((n - j - i) <= 1) {
					stars += "*";
				} else {
					stars += " ";
				}
			}
			System.out.println(stars);
		}
	}

	// Q. 02
	public static String reverseStr(String example) {
		String result = "";
		for (int i = example.length(); i > 0; i--) {
			result += example.substring(i - 1, i);
		}
		return result;
	}

	// Q. 03
	public static int makeRandom(int start, int end) {
		return (int) ((Math.random() * Math.abs(end - start + 1)) + start);
	}

	public static void main(String[] args) {

		// Q. 01
		makeTree(5);
		makeTree(7);

		System.out.println();

		// Q. 02
		String example = "로꾸꺼 로꾸꺼";
		String result = reverseStr(example);
		System.out.println(result);

		System.out.println();

		// Q. 03
		int rand = makeRandom(10, 20);
		System.out.println(rand);
	}
}

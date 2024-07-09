package hyeongyu.submit03;

public class Submit03 {
	public static void main(String[] args) {

		// Q. 01
		int factorial10 = 1;
		for (int i = 10; i > 0; i--) {
			factorial10 *= i;
		}
		System.out.println("결과 : " + factorial10);

		long factorical15 = 1L;
		for (int i = 15; i > 0; i--) {
			factorical15 *= i;
		}
		System.out.println("결과 : " + factorical15);

		System.out.println();

		// Q. 02
		String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";

		int count = 0;
		for (int i = 0; i < findWally.length() - 1; i++) {
			String tmp = findWally.substring(i, i + 2);
			if (tmp.equals("월리")) {
				count++;
			}
		}
		System.out.println(count);

		// Q. 03
		String stars = "*****";

		for (int i = stars.length(); i > 0; i--) {
			stars = stars.substring(0, i);
			System.out.println(stars);
		}
	}
}
package ch05_control;

public class RacingMain {
	public static void main(String[] args) throws InterruptedException {
		String lane1 = "1. ";
		String lane2 = "2. ";
		String lane3 = "3. ";
		String lane4 = "4. ";

		String car1 = "🚙";
		String car2 = "🚗";
		String car3 = "🚕";
		String car4 = "🚌";

		while (true) {
			int random = (int) (Math.random() * 4);

			if (random == 0) {
				lane1 += " ";
			} else if (random == 1) {
				lane2 += " ";
			} else if (random == 2) {
				lane3 += " ";
			} else if (random == 3) {
				lane4 += " ";
			}

			for (int i = 0; i < 20; i++)
				System.out.println();

			System.out.println("------------------------------------------");
			System.out.println(lane1 + car1);
			System.out.println(lane2 + car2);
			System.out.println(lane3 + car3);
			System.out.println(lane4 + car4);
			System.out.println("------------------------------------------");

			if (lane1.length() == 40) {
				System.out.println("1번 차 승리!!");
				break;
			} else if (lane2.length() == 40) {
				System.out.println("2번 차 승리!!");
				break;
			} else if (lane3.length() == 40) {
				System.out.println("3번 차 승리!!");
				break;
			} else if (lane4.length() == 40) {
				System.out.println("4번 차 승리!!");
				break;
			}

			Thread.sleep(100);
		}
	}
}

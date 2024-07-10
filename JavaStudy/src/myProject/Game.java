package myProject;

import java.time.Duration;

public class Game {
	// 타이틀 화면
	public Game() {
		System.out.println("\r\n"
				+ "  __  __ _                                                   \r\n"
				+ " |  \\/  (_)                                                  \r\n"
				+ " | \\  / |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ \r\n"
				+ " | |\\/| | | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\r\n"
				+ " | |  | | | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |   \r\n"
				+ " |_|  |_|_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   \r\n"
				+ "                                            | |              \r\n"
				+ "                                            |_|              \r\n"
				+ "");
		System.out.println(
				"---------------------------------------------------------------------------------");
		System.out.println("PRESS ANY KEY TO START");
		Console.start();
		GameStart();
	}

	private void GameStart() {
		MineGame mineGame = MineGame.getInstance();
		boolean checkClear = false;
		// 클리어 할때까지 반복
		while (!checkClear) {
			Console.clear();
			// 필드의 현재 상황 출력
			for (int i = 0; i < mineGame.getShowField().length; i++) {
				for (int j = 0; j < mineGame.getShowField()[i].length; j++) {
					if (mineGame.getShowField()[i][j] == 0) {
						System.out.print("□");
					} else {
						System.out.print(mineGame.getField()[i][j]);
					}
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println(
					"---------------------------------------------------------------------------------");
			int result[] = Console.answer();
			int answer = mineGame.checkMine(result[1], result[0]);
			// 올바른 값을 입력하지 않았을 때
			while (answer == 0) {
				result = Console.answer();
				answer = mineGame.checkMine(result[1], result[0]);
			}
			// 올바른 값을 입력했을 때
			if (answer == 1) {
				checkClear = mineGame.checkClear();
				// 지뢰를 밟았을 때
			} else {
				Console.clear();
				System.out.println("\r\n"
						+ "   _____          __  __ ______ ______      ________ _____  \r\n"
						+ "  / ____|   /\\   |  \\/  |  ____/ __ \\ \\    / /  ____|  __ \\ \r\n"
						+ " | |  __   /  \\  | \\  / | |__ | |  | \\ \\  / /| |__  | |__) |\r\n"
						+ " | | |_ | / /\\ \\ | |\\/| |  __|| |  | |\\ \\/ / |  __| |  _  / \r\n"
						+ " | |__| |/ ____ \\| |  | | |___| |__| | \\  /  | |____| | \\ \\ \r\n"
						+ "  \\_____/_/    \\_\\_|  |_|______\\____/   \\/   |______|_|  \\_\\\r\n"
						+ "                                                            \r\n"
						+ "                                                            \r\n"
						+ "");
				System.out.println(
						"---------------------------------------------------------------------------------");
				break;
			}
		}
		// 성공했을 때
		if (checkClear == true) {
			Console.clear();
			System.out.println("\r\n"
					+ "   _____ _      ______          _____  \r\n"
					+ "  / ____| |    |  ____|   /\\   |  __ \\ \r\n"
					+ " | |    | |    | |__     /  \\  | |__) |\r\n"
					+ " | |    | |    |  __|   / /\\ \\ |  _  / \r\n"
					+ " | |____| |____| |____ / ____ \\| | \\ \\ \r\n"
					+ "  \\_____|______|______/_/    \\_\\_|  \\_\\\r\n"
					+ "                                       \r\n"
					+ "                                       \r\n"
					+ "");
			System.out.println(
					"---------------------------------------------------------------------------------");
			System.out.println(
					"클리어 시간 : " + Duration.between(mineGame.getStart(), mineGame.getEnd()).getSeconds() + " 초");
		}
		String reply = Console.reStart();
		if (reply.equals("Y") || reply.equals("y")) {
			mineGame.reStart();
			GameStart();
		}
	}
}

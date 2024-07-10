package myProject;

import java.time.Duration;

public class Game {
	//타이틀 화면
	public Game() {
		System.out.println(
				"                                                                                                            \r\n"
						+ "            /'\\_/`\\     __                                                                                  \r\n"
						+ "           /\\      \\   /\\_\\     ___       __     ____   __  __  __     __      __    _____      __    _ __  \r\n"
						+ "           \\ \\ \\__\\ \\  \\/\\ \\  /' _ `\\   /'__`\\  /',__\\ /\\ \\/\\ \\/\\ \\  /'__`\\  /'__`\\ /\\ '__`\\  /'__`\\ /\\`'__\\\r\n"
						+ "            \\ \\ \\_/\\ \\  \\ \\ \\ /\\ \\/\\ \\ /\\  __/ /\\__, `\\\\ \\ \\_/ \\_/ \\/\\  __/ /\\  __/ \\ \\ \\L\\ \\/\\  __/ \\ \\ \\/ \r\n"
						+ "             \\ \\_\\\\ \\_\\  \\ \\_\\\\ \\_\\ \\_\\\\ \\____\\\\/\\____/ \\ \\___x___/'\\ \\____\\\\ \\____\\ \\ \\ ,__/\\ \\____\\ \\ \\_\\ \r\n"
						+ "              \\/_/ \\/_/   \\/_/ \\/_/\\/_/ \\/____/ \\/___/   \\/__//__/   \\/____/ \\/____/  \\ \\ \\/  \\/____/  \\/_/ \r\n"
						+ "                                                                                       \\ \\_\\                \r\n"
						+ "                                                                                        \\/_/                \r\n"
						+ "");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("PRESS ANY KEY TO START");
		Console.start();
		GameStart();
	}

	private void GameStart() {
		MineGame mineGame = MineGame.getInstance();
		boolean checkClear = false;
		//클리어 할때까지 반복
		while (!checkClear) {
			Console.clear();
			//필드의 현재 상황 출력
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
			int result[] = Console.answer();
			int answer = mineGame.checkMine(result[1], result[0]);
			//올바른 값을 입력하지 않았을 때
			while (answer == 0) {
				result = Console.answer();
				answer = mineGame.checkMine(result[1], result[0]);
			}
			//올바른 값을 입력했을 때
			if (answer == 1) {
				checkClear = mineGame.checkClear();
			//지뢰를 밟았을 때
			} else {
				Console.clear();
				System.out.println(
						" ____       ______                  ____       _____       __  __     ____       ____       \r\n"
								+ "/\\  _`\\    /\\  _  \\     /'\\_/`\\    /\\  _`\\    /\\  __`\\    /\\ \\/\\ \\   /\\  _`\\    /\\  _`\\     \r\n"
								+ "\\ \\ \\L\\_\\  \\ \\ \\L\\ \\   /\\      \\   \\ \\ \\L\\_\\  \\ \\ \\/\\ \\   \\ \\ \\ \\ \\  \\ \\ \\L\\_\\  \\ \\ \\L\\ \\   \r\n"
								+ " \\ \\ \\L_L   \\ \\  __ \\  \\ \\ \\__\\ \\   \\ \\  _\\L   \\ \\ \\ \\ \\   \\ \\ \\ \\ \\  \\ \\  _\\L   \\ \\ ,  /   \r\n"
								+ "  \\ \\ \\/, \\  \\ \\ \\/\\ \\  \\ \\ \\_/\\ \\   \\ \\ \\L\\ \\  \\ \\ \\_\\ \\   \\ \\ \\_/ \\  \\ \\ \\L\\ \\  \\ \\ \\\\ \\  \r\n"
								+ "   \\ \\____/   \\ \\_\\ \\_\\  \\ \\_\\\\ \\_\\   \\ \\____/   \\ \\_____\\   \\ `\\___/   \\ \\____/   \\ \\_\\ \\_\\\r\n"
								+ "    \\/___/     \\/_/\\/_/   \\/_/ \\/_/    \\/___/     \\/_____/    `\\/__/     \\/___/     \\/_/\\/ /\r\n"
								+ "                                                                                            \r\n"
								+ "                                                                                            \r\n"
								+ "");
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------------------");
				break;
			}
		}
		//성공했을 때
		if(checkClear == true) {
			Console.clear();
			System.out.println(" ____       __         ____       ______      ____       \r\n"
					+ "/\\  _`\\    /\\ \\       /\\  _`\\    /\\  _  \\    /\\  _`\\     \r\n"
					+ "\\ \\ \\/\\_\\  \\ \\ \\      \\ \\ \\L\\_\\  \\ \\ \\L\\ \\   \\ \\ \\L\\ \\   \r\n"
					+ " \\ \\ \\/_/_  \\ \\ \\  __  \\ \\  _\\L   \\ \\  __ \\   \\ \\ ,  /   \r\n"
					+ "  \\ \\ \\L\\ \\  \\ \\ \\L\\ \\  \\ \\ \\L\\ \\  \\ \\ \\/\\ \\   \\ \\ \\\\ \\  \r\n"
					+ "   \\ \\____/   \\ \\____/   \\ \\____/   \\ \\_\\ \\_\\   \\ \\_\\ \\_\\\r\n"
					+ "    \\/___/     \\/___/     \\/___/     \\/_/\\/_/    \\/_/\\/ /\r\n"
					+ "                                                         \r\n"
					+ "                                                         \r\n" + "");
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("클리어 시간 : "+Duration.between(mineGame.getStart(),mineGame.getEnd()).getSeconds()+" 초");
		}
	}
}

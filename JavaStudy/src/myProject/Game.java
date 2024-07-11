package myProject;

import java.time.Duration;

public class Game {
	// 타이틀 화면
	public Game() {
		Console.title();
		GameStart();
	}

	//게임 시작
	private void GameStart() {
		MineGame mineGame = MineGame.getInstance();
		boolean checkClear = false;
		// 클리어 할때까지 반복
		while (!checkClear) {
			Console.currentField(mineGame.mineField());
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
				Console.gameOver();
				break;
			}
		}
		// 성공했을 때
		if (checkClear == true) {
			Console.gameClear(Duration.between(mineGame.getStart(), mineGame.getEnd()).getSeconds());
		}
		String reply = Console.reStart();
		if (reply.equals("Y") || reply.equals("y")) {
			mineGame.reStart();
			GameStart();
		}
	}
}

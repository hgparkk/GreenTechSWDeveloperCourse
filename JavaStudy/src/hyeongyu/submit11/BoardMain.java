package hyeongyu.submit11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BoardMain {
	private ArrayList<Board> boardList = new ArrayList<>();

	private BoardMain() {
	}

	private static BoardMain instance = new BoardMain();

	public static BoardMain getInstance() {
		return instance;
	}

	public void boardList() throws ParseException {
		for (Board b : boardList) {
			System.out.println("[ " + b.getBoardNum() + " | " + b.getTitle() + " | " + b.getInputTime() + " ]");
		}
	}

	public void insertBoard(String title, String content) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Board board = new Board(boardList.size() + 1, title, sdf.format(new Date()), content);
		boardList.add(board);
	}
}
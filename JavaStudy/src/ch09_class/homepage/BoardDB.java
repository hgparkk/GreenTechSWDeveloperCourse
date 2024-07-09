package ch09_class.homepage;

import java.util.ArrayList;

public class BoardDB {
	private ArrayList<Board> boardList = new ArrayList<>();

	private BoardDB() {
		boardList.add(new Board("첫 번째 게시글 제목", "호빵맨", "첫 번째 게시글 내용"));
		boardList.add(new Board("두 번째 게시글 제목", "찐빵맨", "두 번째 게시글 내용"));
		boardList.add(new Board("세 번째 게시글 제목", "꿀빵맨", "세 번째 게시글 내용"));
	}

	private static BoardDB instance = new BoardDB();

	public static BoardDB getInstance() {
		return instance;
	}

	public void boardList() {
		int count = 1;
		for (Board b : boardList) {
			System.out.println("[ " + count + " | " + b.getTitle() + " | " + b.getAutherName() + " ]");
			count++;
		}
	}

	public void insertBoard(Board board) {
		boardList.add(board);
	}

	public void showBoard(int index) {
		if (index >= boardList.size()) {
			System.out.println("게시글이 존재하지 않습니다");
			return;
		}
		System.out.println(boardList.get(index));
	}
}

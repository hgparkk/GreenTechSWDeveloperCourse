package hyeongyu.submit11;

public class Board {
	private int boardNum;
	private String title;
	private String inputTime;
	private String content;
	
	public Board(int boardNum, String title, String inputTime, String contents) {
		this.boardNum = boardNum;
		this.title = title;
		this.inputTime = inputTime;
		this.content = contents;
	}

	public int getBoardNum() {
		return boardNum;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getInputTime() {
		return inputTime;
	}
}
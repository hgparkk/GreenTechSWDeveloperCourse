package com.spring.study.board.dto;

import javax.validation.constraints.Pattern;

public class BoardDTO {
	private int boardNo;
	@Pattern(regexp = "^.{5,}$",message="���񿡴� 5���� �̻� �ۼ��Ͽ� �ּ���.")
	private String boardTitle;
	private String memId;
	private String memName;
	private String boardContent;
	private String boardDate;

	public BoardDTO() {
	}

	public BoardDTO(int boardNo, String boardTitle, String memId, String memName, String boardContent,
			String boardDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.memId = memId;
		this.memName = memName;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memId=" + memId + ", memName="
				+ memName + ", boardContent=" + boardContent + ", boardDate=" + boardDate + "]";
	}
}
package com.spring.study.board.dto;

public class BoardDTO {
	private int cBoardNo;
	private String cBoardTitle;
	private String cMemId;
	private String cMemName;
	private String cBoardContent;
	private String cBoardDate;
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int cBoardNo, String cBoardTitle, String cMemId, String cMemName, String cBoardContent,
			String cBoardDate) {
		super();
		this.cBoardNo = cBoardNo;
		this.cBoardTitle = cBoardTitle;
		this.cMemId = cMemId;
		this.cMemName = cMemName;
		this.cBoardContent = cBoardContent;
		this.cBoardDate = cBoardDate;
	}

	public int getcBoardNo() {
		return cBoardNo;
	}

	public void setcBoardNo(int cBoardNo) {
		this.cBoardNo = cBoardNo;
	}

	public String getcBoardTitle() {
		return cBoardTitle;
	}

	public void setcBoardTitle(String cBoardTitle) {
		this.cBoardTitle = cBoardTitle;
	}

	public String getcMemId() {
		return cMemId;
	}

	public void setcMemId(String cMemId) {
		this.cMemId = cMemId;
	}

	public String getcMemName() {
		return cMemName;
	}

	public void setcMemName(String cMemName) {
		this.cMemName = cMemName;
	}

	public String getcBoardContent() {
		return cBoardContent;
	}

	public void setcBoardContent(String cBoardContent) {
		this.cBoardContent = cBoardContent;
	}

	public String getcBoardDate() {
		return cBoardDate;
	}

	public void setcBoardDate(String cBoardDate) {
		this.cBoardDate = cBoardDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [cBoardNo=" + cBoardNo + ", cBoardTitle=" + cBoardTitle + ", cMemId=" + cMemId + ", cMemName="
				+ cMemName + ", cBoardContent=" + cBoardContent + ", cBoardDate=" + cBoardDate + "]";
	}
}
package com.spring.study.reply.dto;

public class ReplyDTO {
	private String replyNo;
	private int boardNo;
	private String memId;
	private String memName;
	private String replyContent;
	private String replyDate;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(String replyNo, int boardNo, String memId, String memName, String replyContent, String replyDate) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memId = memId;
		this.memName = memName;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memId=" + memId + ", memName=" + memName
				+ ", replyContent=" + replyContent + ", replyDate=" + replyDate + "]";
	}
}
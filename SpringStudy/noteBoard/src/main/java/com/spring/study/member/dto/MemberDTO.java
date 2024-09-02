package com.spring.study.member.dto;

public class MemberDTO {
	private String cMemId;
	private String cMemPw;
	private String cMemName;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(String cMemId, String cMemPw, String cMemName) {
		super();
		this.cMemId = cMemId;
		this.cMemPw = cMemPw;
		this.cMemName = cMemName;
	}

	public String getcMemId() {
		return cMemId;
	}

	public void setcMemId(String cMemId) {
		this.cMemId = cMemId;
	}

	public String getcMemPw() {
		return cMemPw;
	}

	public void setcMemPw(String cMemPw) {
		this.cMemPw = cMemPw;
	}

	public String getcMemName() {
		return cMemName;
	}

	public void setcMemName(String cMemName) {
		this.cMemName = cMemName;
	}

	@Override
	public String toString() {
		return "MemberDTO [cMemId=" + cMemId + ", cMemPw=" + cMemPw + ", cMemName=" + cMemName + "]";
	}
}
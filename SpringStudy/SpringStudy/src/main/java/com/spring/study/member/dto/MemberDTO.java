package com.spring.study.member.dto;

public class MemberDTO {
	private String memId;
	private String memPassword;
	private String memName;
	private String memPhone;
	private String memEmail;

	public MemberDTO() {
	}

	public MemberDTO(String memId, String memPassword, String memName, String memPhone, String memEmail) {
		this.memId = memId;
		this.memPassword = memPassword;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", memPassword=" + memPassword + ", memName=" + memName + ", memPhone="
				+ memPhone + ", memEmail=" + memEmail + "]";
	}
}
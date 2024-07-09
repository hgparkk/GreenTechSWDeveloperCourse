package ch09_class.homepage;

public class Member {
	String memid;
	String memPw;
	String memName;

	public Member() {
	}

	public Member(String memid, String memPw, String memName) {
		super();
		this.memid = memid;
		this.memPw = memPw;
		this.memName = memName;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
}
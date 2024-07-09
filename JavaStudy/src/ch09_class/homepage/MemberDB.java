package ch09_class.homepage;

import java.util.ArrayList;

public class MemberDB {
	private ArrayList<Member> memList = new ArrayList<>();

	private MemberDB() { // 싱글톤 패턴
	};

	private static MemberDB instance = new MemberDB();

	public static MemberDB getInstance() { // 정적인 생성자를 통해 생성된 instance에 접근하도록 함
		return instance;
	}
}
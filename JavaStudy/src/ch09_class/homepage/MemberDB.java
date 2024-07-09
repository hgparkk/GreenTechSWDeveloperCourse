package ch09_class.homepage;

import java.util.ArrayList;

public class MemberDB {
	private ArrayList<Member> memList = new ArrayList<>();

	private MemberDB() { // 싱글톤 패턴
		memList.add(new Member("a001", "123a", "호빵맨"));
		memList.add(new Member("b001", "123b", "찐빵맨"));
		memList.add(new Member("c001", "123c", "꿀빵맨"));
	};

	private static MemberDB instance = new MemberDB();

	public static MemberDB getInstance() { // 정적인 생성자를 통해 생성된 instance에 접근하도록 함
		return instance;
	}

	public void insertMember(Member mem) {
		for (Member m : memList) {
			if (m.getMemId().equals(mem.getMemId())) {
				System.out.println("중복되는 아이디가 있습니다.");
				return;
			}
		}
		memList.add(mem);
		System.out.println("회원가입 성공");
	}

	public void showMemList() {
		for (Member m : memList) {
			System.out.println(m);
		}
	}

	public Member login(String id, String pw) {
		for (Member m : memList) {
			if (m.getMemId().equals(id) && m.getMemPw().equals(pw)) {
				return m;
			}
		}
		return null;
	}
}
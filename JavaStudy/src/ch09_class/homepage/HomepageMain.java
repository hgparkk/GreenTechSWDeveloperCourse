package ch09_class.homepage;

import java.util.Scanner;

public class HomepageMain {
	public static void main(String[] args) {
		MemberDB memDB = MemberDB.getInstance();
		BoardDB boardDB = BoardDB.getInstance();

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원 목록 | 4. 종료");
			System.out.print(">>> ");

			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				
				System.out.print("아이디 입력 : ");
				String id = scan.nextLine();
				System.out.print("비빌번호 입력 : ");
				String pw = scan.nextLine();
				System.out.print("닉네임 입력 : ");
				String name = scan.nextLine();

				Member mem = new Member(id, pw, name);

				memDB.insertMember(mem);
				
			} else if (command == 2) {
				
				System.out.print("아이디 입력 : ");
				String id = scan.nextLine();
				System.out.print("비빌번호 입력 : ");
				String pw = scan.nextLine();

				Member login = memDB.login(id, pw);
				
				if (login != null) {
					System.out.println("로그인 성공");
					System.out.println(login.getMemName() + "님 환영합니다.");
					
					while (true) {
						boardDB.boardList();
						System.out.println("행동을 선택해주세요.");
						System.out.println("1. 글쓰기 | 2. 글보기 | 3. 로그아웃");
						System.out.print(">>> ");
						
						command = Integer.parseInt(scan.nextLine());
						
						if (command == 1) {
							System.out.print("글 제목 입력: ");
							String title = scan.nextLine();
							System.out.print("글 내용 입력: ");
							String contents = scan.nextLine();

							Board board = new Board(title, login.getMemName(), contents);
							boardDB.insertBoard(board);
							
						} else if (command == 2) {
							System.out.print("글 번호 입력: ");
							int index = Integer.parseInt(scan.nextLine()) - 1;
							
							boardDB.showBoard(index);
							
						} else if (command == 3) {
							break;
						}
					}
				} else {
					System.out.println("유효하지 않은 아이디 혹은 비밀번호 입니다.");
				}
			} else if (command == 3) {
				memDB.showMemList();
				
			} else if (command == 4) {
				break;
			}
		}
	}
}
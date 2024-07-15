package hyeongyu.submit11;

import java.text.ParseException;
import java.util.Scanner;

public class Submit11 {
	public static void main(String[] args) throws ParseException {
		// Q. 01
		BoardMain boardMain = BoardMain.getInstance();

		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(scan.nextLine());
			if(command == 1) {
				boardMain.boardList();
			}else if(command == 2) {
				System.out.print("글 제목을 입력해주세요: ");
				String title = scan.nextLine();
				System.out.print("글 내용을 입력해주세요: ");
				String content = scan.nextLine();
				boardMain.insertBoard(title, content);
			}else {
				scan.close();
				break;
			}
		}
	}
}
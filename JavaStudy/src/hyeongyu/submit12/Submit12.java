package hyeongyu.submit12;

import java.util.ArrayList;
import java.util.Scanner;

public class Submit12 {
	public static void main(String[] args) {

		// 싱글톤 객체 호출
		Library instance = Library.getInstance();

		// 스캐너 호출
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("행동을 선택해주세요");
			System.out.println("1. 책 입고 | 2. 책 대여 | 3. 책 목록 | 4. 책 검색 | 5. 종료");
			System.out.print(">>> ");
			int command = Integer.parseInt(scan.nextLine());

			// 책 입고
			if (command == 1) {
				System.out.println("책 번호를 입력해주세요");
				System.out.print(">>> ");
				int bookNum = Integer.parseInt(scan.nextLine());

				// 책이 대여중이면
				if (instance.getBookList().get(bookNum - 1).isLoan()) {
					instance.returning(bookNum - 1);
					System.out.println(instance.getBookList().get(bookNum - 1).getBookTitle() + "이(가) 입고되었습니다.");
				} else {
					System.out.println(instance.getBookList().get(bookNum - 1).getBookTitle() + "은(는) 대여중인 책이 아닙니다.");
				}

				// 책 대여
			} else if (command == 2) {
				System.out.println("책 이름을 입력해주세요: ");
				String word = scan.nextLine();
				ArrayList<Book> searchedList = instance.searchBook(word);
				int bookNum = 0;

				// 검색된 책이 없으면
				if (searchedList.size() == 0) {
					System.out.println("검색된 도서가 없습니다.");
					continue;
				}

				// 검색된 책 중 입고중인 책만 출력
				else if (searchedList.size() != 1) {
					boolean check = false;
					for (Book b : searchedList) {
						if (!b.isLoan()) {
							check = true;
							System.out.println(b);
						}
					}
					if (!check) {
						System.out.println("검색된 책들이 모두 대여중입니다.");
						continue;
					}
					System.out.println("도서 번호를 입력해주세요: ");
					bookNum = Integer.parseInt(scan.nextLine());

					// 검색된 책이 하나라면
				} else {
					bookNum = searchedList.get(0).getBookNum();
				}

				if (!instance.getBookList().get(bookNum - 1).isLoan()) {
					instance.loan(bookNum - 1);
					System.out.println(instance.getBookList().get(bookNum - 1).getBookTitle() + "을(를) 대여하셨습니다.");
				} else {
					System.out.println(instance.getBookList().get(bookNum - 1).getBookTitle() + "은(는) 입고중인 책이 아닙니다.");
				}

				// 책 목록
			} else if (command == 3) {
				ArrayList<Book> bookList = instance.getBookList();
				for (Book b : bookList) {
					System.out.println(b);
				}

				// 책 검색
			} else if (command == 4) {
				System.out.println("책 이름을 입력해주세요: ");
				String word = scan.nextLine();
				ArrayList<Book> searchedList = instance.searchBook(word);
				if (searchedList.size() == 0) {
					System.out.println("검색된 책이 없습니다");
				} else {
					for (Book b : searchedList) {
						System.out.println(b);
					}
				}
			} else if (command == 5) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		scan.close();
	}
}
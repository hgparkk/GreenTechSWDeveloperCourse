package hyeongyu.submit12;

import java.util.ArrayList;

public class Library {
	// 입고될 책의 번호
	private int bookNum = 1;
	private ArrayList<Book> bookList = new ArrayList<>();;

	// 도서관 초기화
	private Library() {
		String strBooks = "삼국지, 해리포터와 마법사의 돌, 해리포터와 비밀의 방 , 해리포터와 아즈카반의 죄수,해리포터와 불사조 기사단, 해리포터와 혼혈왕자, 해리포터와 죽음의 성물,어린왕자, 나의 라임 오렌지나무, 이것이 자바다, 좋은생각, 반지의 제왕: 반지 원정대, 반지의 제왕: 두 개의 탑, 반지의 제왕: 왕의 귀환, 토익보카, 개미";
		String[] bookArray = strBooks.split(",");
		for (String s : bookArray) {
			insertBook(s.trim());
		}
	}

	private static Library instance = new Library();

	public static Library getInstance() {
		return instance;
	}

	public void insertBook(String title) {
		bookList.add(new Book(bookNum, title));
		bookNum++;
	}

	// 책 입고
	public void returning(int i) {
		bookList.get(i).setLoan(false);
	}

	// 책 대여
	public void loan(int i) {
		bookList.get(i).setLoan(true);
	}

	// 책 목록
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	// 책 검색
	public ArrayList<Book> searchBook(String word) {
		ArrayList<Book> searchedBook = new ArrayList<>();
		for (Book b : bookList) {
			if (b.getBookTitle().contains(word)) {
				searchedBook.add(b);
			}
		}
		return searchedBook;
	}
}
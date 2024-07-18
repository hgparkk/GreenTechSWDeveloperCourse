package hyeongyu.submit12;

public class Book {
	private int bookNum;
	private String bookTitle;
	private boolean loan = false;

	public Book(int bookNum, String bookTitle) {
		this.bookNum = bookNum;
		this.bookTitle = bookTitle;
	}

	public int getBookNum() {
		return bookNum;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public boolean isLoan() {
		return loan;
	}

	public void setLoan(boolean loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return (loan) ? ("[책번호: " + bookNum + ", 책 제목: " + bookTitle + ", 대여상태: 대여중 ]")
				: ("[책번호: " + bookNum + ", 책 제목: " + bookTitle + ", 대여상태: 입고중]");
	}
}
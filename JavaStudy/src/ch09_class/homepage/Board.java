package ch09_class.homepage;

public class Board {
	private String title;
	private String autherName;
	private String contents;

	public Board() {
	};

	public Board(String title, String autherName, String contents) {
		this.title = title;
		this.autherName = autherName;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherId(String autherName) {
		this.autherName = autherName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "============\n제목: " + title + "\n작성자: " + autherName + "\n- - - - - - - -\n" + contents
				+ "\n============";
	}
}
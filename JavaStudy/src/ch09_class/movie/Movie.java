package ch09_class.movie;

public class Movie {
	String title;
	String goat;
	String hint;

	public Movie() {
	}

	public Movie(String title, String goat, String hint) {
		this.title = title;
		this.goat = goat;
		this.hint = hint;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", goat=" + goat + "]";
	}
}
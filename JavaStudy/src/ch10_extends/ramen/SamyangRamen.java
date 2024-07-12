package ch10_extends.ramen;

public class SamyangRamen extends Ramen {
	public SamyangRamen() {
		super("삼양라면", 1000, "삼양");
	}

	@Override
	public void printRecipe() {
		System.out.println("끓는 물에 면과 스프를 넣고 3분 후 드세요");
	}
}
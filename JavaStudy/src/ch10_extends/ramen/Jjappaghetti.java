package ch10_extends.ramen;

public class Jjappaghetti extends Ramen {
	public Jjappaghetti() {
		super("짜파게티", 1000, "농심");
	}

	@Override
	public void printRecipe() {
		System.out.println("끓는 물에 면을 넣어 4분간 삶고 물을 버린 후 스프를 넣고 비벼 드세요");
	}
}
package ch10_extends.ramen;

public class RamenMain {
	public static void main(String[] args) {
		SamyangRamen samyang = new SamyangRamen();
		samyang.printRecipe();

		Jjappaghetti jjappaghetti = new Jjappaghetti();
		jjappaghetti.printRecipe();
		
		Ramen sin = new Ramen() {
			@Override
			public void printRecipe() {
				System.out.println("끓는 물에 면과 스프를 넣고 3분 후 드세요");
			}
		};
		
		sin.printRecipe();
	}
}
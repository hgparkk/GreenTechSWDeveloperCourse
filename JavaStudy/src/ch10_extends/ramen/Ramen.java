package ch10_extends.ramen;

public abstract class Ramen {
	String name;
	int price;
	String company;

	public Ramen() {
	};

	public Ramen(String name, int price, String company) {
		this.name = name;
		this.price = price;
		this.company = company;
	}

	public abstract void printRecipe();
}
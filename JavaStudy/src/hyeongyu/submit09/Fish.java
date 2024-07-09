package hyeongyu.submit09;

public class Fish {
	private String name;
	private int price;

	public Fish() {
	};

	public Fish(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "[" + name + ", 가치=" + price + "]";
	}
}

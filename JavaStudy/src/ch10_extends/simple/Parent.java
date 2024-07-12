package ch10_extends.simple;

public class Parent {
	private String name;
	private int age;

	public Parent() {
	}

	public Parent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void hello() {
		System.out.println("안녕하세요 어른입니다.");
	}
	
	public void work() {
		System.out.println("열심히 일하는 중");
	}

	@Override // 모든 클래스는 Object 클래스를 상속받고 있다.
	public String toString() { // toString 메소드는 Object 클래스에 존재하는 메소드
		return "Parent [name=" + name + ", age=" + age + "]";
	}
}
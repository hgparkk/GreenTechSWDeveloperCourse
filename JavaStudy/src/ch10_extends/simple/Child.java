package ch10_extends.simple;

public class Child extends Parent{

	public Child() {
		super();
	}

	public Child(String name, int age) {
		super(name, age);
	}
	
	@Override // 어노테이션 Override : 부모 클래스가 가진 메소드를 자식 클래스에서 재정의
	public void hello() {
		System.out.println("안녕하세요 어린이입니다.");
	}

	@Override
	public String toString() {
		return "Child [name=" + getName() + ", age=" + getAge() + "]";
	}
}
package ch09_class.student;

public class Student {
	String name;
	int level = 1;
	int exp;

	public Student() {
	};

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, int level, int exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}

	public void afterOneDay() {
		this.exp += (int) ((Math.random() * 31) + 20);
		if (this.exp >= 100) {
			this.level++;
			System.out.println(this.name + " 레벨업!! ");
			this.exp -= 100;
		}
		System.out.println("현재 " + this.name + ": Lv. " + this.level + " (exp: " + this.exp + "%)");
	}

	@Override
	public String toString() {
		return "Student [name=" + this.name + ", level=" + this.level + ", exp=" + this.exp + "]";
	}
}
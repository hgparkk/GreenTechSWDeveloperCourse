package ch10_extends.simple;

public class SimpleMain {
	public static void main(String[] agrs) {
		Parent father = new Parent("신형만",30);
		
		System.out.println(father);
		System.out.println(father.toString());
		
		father.hello();
		father.work();
		
		Child Jjanggu = new Child();
		
		System.out.println(Jjanggu);
		
		//Child 객체는 Parent의 메소드를 가지고 있다.
		Jjanggu.hello();
		Jjanggu.work();
		
		Jjanggu.setName("신짱구");
		Jjanggu.setAge(5);
		System.out.println(Jjanggu);
		
		Child Jjangah = new Child("신짱아",2);
		System.out.println(Jjangah);
		
		Jjangah.hello();
		Jjangah.work();
		
		Object god = new Object();
		
		System.out.println(god);
		
		//Student hobbang = new Student();
		//Child child = (Child)hobbang; 기본적으로는 객체간 형 변환은 불가능함.
		
		Parent adultJjanggu = (Parent)Jjanggu; // 자식은 부모로 형 변환이 가능하다.
		
		System.out.println(adultJjanggu);
		adultJjanggu.hello(); // Child의 메소드가 실행됨.
		adultJjanggu.work();
		
		// Child child = (Child)father; 기본적으로는 부모는 자식으로 형 변환이 불가능하다.
		
		Child again = (Child)adultJjanggu; // 부모로 형 변환 된 자식 객체는 자식으로 형 변환이 가능하다.

	}
}
package ch09_class.pokemon;

import java.util.ArrayList;

public class PokemonMain {
	public static void main(String[] args) {
		Pokemon bulbasaur = new Pokemon();

		System.out.println(bulbasaur);

		System.out.println(bulbasaur.name); // 필드변수에 값을 담아주지 않으면 생성된 객체의 필드들은 기본값을 가진다. 숫자는 0, boolean은 false, 참조타입은
											// null

		System.out.println(bulbasaur.no);

		bulbasaur.name = "이상해씨";
		bulbasaur.no = 1;
		bulbasaur.type = "풀";
		bulbasaur.species = "씨앗포켓몬";

		System.out.println(bulbasaur);

		System.out.println(bulbasaur.name);
		System.out.println(bulbasaur.no);
		System.out.println(bulbasaur.type);
		System.out.println(bulbasaur.species);

		Pokemon charmander = new Pokemon();

		charmander.name = "파이리";
		charmander.no = 2;
		charmander.type = "불";
		charmander.species = "도룡뇽포켓몬";

		System.out.println(charmander); // 객체를 println 하면 객체의 toString() 실행 결과가 출력, toString() 함수를 재정의하지 않으면 메모리주소를
										// 가르킨다.

		Pokemon squirtle = new Pokemon();

		squirtle.name = "꼬북이";
		squirtle.no = 3;
		squirtle.type = "물";
		squirtle.species = "꼬마거북포켓몬";

		System.out.println(squirtle);

		System.out.println("=========================================================");

		Pokemon pikachu = new Pokemon("피카츄", 4, "전기", "쥐포켓몬");

		System.out.println(pikachu);

		Pokemon caterpie = new Pokemon("캐터피", 5, "벌레", "애벌레포켓몬");
		Pokemon pidgeotto = new Pokemon("피죤", 6, "비행", "새포켓몬");

		ArrayList<Pokemon> pokeList = new ArrayList<>(); // Ctrl + Shift + o - 자동 import

		pokeList.add(bulbasaur);
		pokeList.add(charmander);
		pokeList.add(squirtle);
		pokeList.add(pikachu);
		pokeList.add(caterpie);
		pokeList.add(pidgeotto);

		System.out.println(pokeList);

		int index = (int) (Math.random() * pokeList.size());
		System.out.println(pokeList.get(index));
	}
}
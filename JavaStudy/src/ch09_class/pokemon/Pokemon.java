package ch09_class.pokemon;

public class Pokemon {
	String name;
	int no;
	String type;
	String species;
	
	public Pokemon() {};

	public Pokemon(String name, int no, String type, String species) {
		this.name = name;
		this.no = no;
		this.type = type;
		this.species = species;
	}

	@Override
	public String toString() { // Alt + Shift + S - toString()
		return "Pokemon [name=" + name + ", no=" + no + ", type=" + type + ", species=" + species + "]";
	}
}
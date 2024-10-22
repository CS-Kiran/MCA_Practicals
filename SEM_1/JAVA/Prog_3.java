package Prog_sem1;

class Animal{
	String name;
	int age;
	
	void sound() {
		System.out.println("Animal Sound");
	}
}

class Dog extends Animal{
	void sound() {
		System.out.println("Bark...");
	}
}

class Cat extends Animal{
	void sound() {
		System.out.println("Meow...");
	}
}

public class Prog_3 {

	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();
		
		c.sound();
		d.sound();

	}

}

package edu.sabanciuniv.cs310.abstractclasses;

public class MainClass {

	public static void main(String[] args) {
		
		//You can not create objects from  abstract classes
		//Animal a = new Animal();
		
		Animal a2 = new Cat();
		Animal a3 = new Dog();
		
		Animal a4 = new Lion();
		a2.sound();
		a3.sound();
		a4.sound();

		a3.sound2();
	}

}

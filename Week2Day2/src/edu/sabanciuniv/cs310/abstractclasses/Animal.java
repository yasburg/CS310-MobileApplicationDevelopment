package edu.sabanciuniv.cs310.abstractclasses;

public abstract class Animal
{

	//Abstract method which do not need any implementation
	public abstract void sound();

	void sound2(){
		System.out.println("sound in Animal class");
	}
	
	public int nonAbstractMethod()
	{
		System.out.println("nonAbstractMethod");
		return 0;
	}

}

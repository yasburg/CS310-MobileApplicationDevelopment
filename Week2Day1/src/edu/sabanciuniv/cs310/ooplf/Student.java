package edu.sabanciuniv.cs310.ooplf;

import edu.sabanciuniv.cs310.other.Human;

public class Student extends Human {
	
	protected int id;
	String name;
	public String lastname;

	//constructor
	public Student(int id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	//default constructor
	public Student() {

		this.id =-1;
		this.lastname = "No lastname";
		this.name = "No name";
//		this.defaultModifierDna = "GCTA";
		this.protectedModifierDna = "ATCG";
	}



	public String toString()
	{
		return this.id+","+this.lastname+","+this.name;
	}

}

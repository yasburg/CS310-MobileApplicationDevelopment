package edu.sabanciuniv.cs310.course;

public class Student 

{
	int id;
	String name;
	String lastname;
	
	//Default (Empty constructor)
	public Student() {

	}

	//Full (copy) constructor
	public Student(int id, String name, String lastname) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	void printStudentInfo()
	{
		System.out.println("id="+id+"  name="+name+"   lastname="+lastname);
	}

}

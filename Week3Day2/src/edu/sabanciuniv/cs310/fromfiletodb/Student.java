package edu.sabanciuniv.cs310.fromfiletodb;

public class Student {
	
	private String name;
	private String lastname;

	
	public Student() {
		super();
	}
	public Student(String name, String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}

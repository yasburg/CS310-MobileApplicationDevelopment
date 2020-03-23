package edu.sabanciuniv.cs310.rs;

public class Employee {
	
	private int id;
	private String name;
	private String  lastname;
	
	
	public Employee() {
		super();
	}
	public Employee(String name,String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

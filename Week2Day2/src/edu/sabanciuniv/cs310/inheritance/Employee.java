package edu.sabanciuniv.cs310.inheritance;

public class Employee {

	//Make all the fields private
	//Generate at least 2 Constructors ( Empty & Full )
	//Generate setter & getter methods
	private int empID;
	private String name;
	private String lastName;
	private double workHours;

	//composition  Employee has an Address
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Employee(int empID, String name, String lastName, double workHours)
	{
		super();
		this.empID = empID;
		this.name = name;
		this.lastName = lastName;
		this.workHours = workHours;
	}

	public Employee()
	{
		this.empID = -1;
		this.lastName = "No Lastname";
		this.name = "No Name";
		this.workHours = 0.0;

	}

	public void setWorkHours(double hour)
	{
		if (hour > 0)
		{
			this.workHours = hour;
		}
		else
		{

			this.workHours = 0;
		}

	}

	public double getWorkHours()
	{
		return this.workHours;
	}

	public void printEmployeeInfo()
	{
		System.out.println(this.empID + "-" +this.name
				+ " - "+this.lastName +" - "+this.workHours);
	}

	//Method Overloading
	//Rewriting the any method
	//in the subclass / current class
	//with different parameters
	public void printEmployeeInfo(int x)
	{
		System.out.println("Overload");
	}

	public void employeeMethod() { System.out.println(" employeeMethod "); }


	public double calculateSalary()
	{
		double total = this.workHours * 200;
		return total;
	}


}

package edu.sabanciuniv.cs310.inheritance;

public class Manager extends Employee{

	private String managedDept;



	public Manager(int empID, String name,
			String lastname, double workHours,
			String managedDept)
	{
		//super constructor call
		//should be done at the first line 
		//of the subclass`s constructor
		super(empID, name, lastname, workHours);
		this.managedDept = managedDept;
	}



	public Manager(String managedDept) {
		super();
		this.managedDept = managedDept;
	}



	public Manager()
	{
		super();
	}

	//Method Overriding
	//Rewriting the inherited methods
	//in the subclass
	//with same parameters

	public void printEmployeeInfo()
	{
		System.out.println(this.getEmpID() + "-"
				+this.getName()
				+ " - "+this.getLastName()+" - "+
				this.getWorkHours() +
				" - " +this.managedDept);
	}


	@Override
	public double calculateSalary() {

		double salary = this.getWorkHours() * 300 + 1000;
		return salary;


	}


	public void managerMethod()
	{
		System.out.println(" managerMethod ");
	}


}

package edu.sabanciuniv.cs310.inheritance;

public class MainClassPolymorphism {

	public static void main(String[] args)
	{
		Employee e1 = new Employee(1, "emp", "lastnameEMP", 40);
		System.out.println(e1.calculateSalary());

		Manager m1 = new Manager(2, "manager", "mlastname", 40, "HR");
		System.out.println(m1.calculateSalary());
		m1.managerMethod();
		Employee e2 =
				new Manager(3, "manager2", "m2lastname", 30, "Sales");


		e2.employeeMethod();
		//By using superclass reference we can only access (Employee)
		//the methods implemented in the superclass(Employee)
		//e2.managerMethod();

		//Polymorphism
		System.out.println(e2.calculateSalary());


	 //For the polymorphism we need 4 things
	 //1-) There must be inheritance
	 //2-) There must be an overridden method
	 //3-) Superclass reference should refer to a subclass object
	 //4-) call the overridden method

	 //Expected scenario ; The method of super class should run
	 //Real (Polymorphic scenario) ; Subclass method runs

	}

}

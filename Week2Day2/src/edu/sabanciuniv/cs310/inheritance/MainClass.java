package edu.sabanciuniv.cs310.inheritance;

public class MainClass {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1, "aaa", "bbb", 20);
		
		emp1.setWorkHours(40.0);
		System.out.println(emp1.getWorkHours());
		
		emp1.printEmployeeInfo();
		
		//emp1.workHours = -112312;
		//System.out.println(emp1.workHours);
		
		Manager m1 = new Manager(123,"manager","managerLastName",10,"IT");
		m1.printEmployeeInfo();

	}

}

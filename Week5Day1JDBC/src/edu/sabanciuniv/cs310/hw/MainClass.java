package edu.sabanciuniv.cs310.hw;

public class MainClass {

	public static void main(String[] args) {
		
		
		Employee e1 = new Employee(0,"Yasin");
		JDBCManager.insertOneEmployee(e1);

	}

}

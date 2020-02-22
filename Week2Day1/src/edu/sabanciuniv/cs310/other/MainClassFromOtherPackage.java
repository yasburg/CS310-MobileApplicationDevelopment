package edu.sabanciuniv.cs310.other;

import edu.sabanciuniv.cs310.ooplf.GradStudent;
import edu.sabanciuniv.cs310.ooplf.Student;

public class MainClassFromOtherPackage {

	public static void main(String[] args) {
		
		Student s1 = new Student(333,"Ahmet","Demirelli");
		
		s1.lastname = "asdasda";//public access modifier -  can be accessed any class
		//s1.name="Test"; //<default> access modifier - can not be accessed by another package
		System.out.println(s1);

	}

}

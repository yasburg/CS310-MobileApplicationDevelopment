package edu.sabanciuniv.cs310.ooplf;

public class MainClass {

	public static void main(String[] args) {
	
		Student s1 = new Student(333,"Ahmet","Demirelli");
		
		//s1.id = 12344342;
		s1.lastname = "asdasda";
		System.out.println(s1);
		
		Student s2 = new Student();
		System.out.println(s2);
		
		GradStudent gs1 = new GradStudent();
		
		gs1.lastname ="GradStuLastname";
		gs1.name = "GS Name";
		gs1.thesisTopic ="Topic";


	}

}

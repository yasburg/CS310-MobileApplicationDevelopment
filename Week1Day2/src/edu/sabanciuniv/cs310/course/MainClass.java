package edu.sabanciuniv.cs310.course;



//Java tradition 1
//Class names must start with upper case letters
//If it contains two words, each words first letter will be upper case and they must be concatenated
public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Test");
		System.out.println("sout + Tab to autofill the method!!");
		
		//Java tradition 2
		//Variable names starts with lowercase 
		//If it is combination of two words, first letter of the first word should be lowercase
		int studentCount = 0;

		Student s1  = new Student(123,"James","Gosling");
		studentCount++;

		System.out.println("Some sys out shortcuts: sout (normal), soutm (method), soutp (parameter), soutv (variable)");

		s1.lastname = "Aydin";
		s1.name = "Yasin";

		System.out.println("soutv to auto create variable out like this:");


		s1.printStudentInfo();
		
		//Garbage collector collect student object
		s1 = null;

	}

}

package edu.sabanciuniv.cs310.course;

public class MainClass2 {

	public static void main(String[] args) 
	{
		
		Student s1  = new Student(122,"James","Gosling");
		Student s2  = new Student(123,"Ryan","Gosling");
		Student s3  = new Student(124,"Ahmet","Gosling");
		Student s4  = new Student(125,"Yasin","Aydin");
		//I want to delete all but Yasin Aydin

		s2 = null;
		s1 = s2;
		s3 = s2;
		s2 = s4;


		System.out.println(s4.name);

		try {
			System.out.println(s1.name);
			System.out.println(s2.name);
			System.out.println(s3.name);
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}


	}

}

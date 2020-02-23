package edu.sabanciuniv.cs310.fromfiletodb;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) 
	{

		ArrayList<Student> allStudents =
				CS310StudentFileReader.readStudentsFromFile("students.csv");
		
		CS310DBWriter.writeListToDB(allStudents);

	}

}

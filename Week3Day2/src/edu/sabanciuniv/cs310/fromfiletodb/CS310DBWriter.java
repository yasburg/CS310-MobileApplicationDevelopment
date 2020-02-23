package edu.sabanciuniv.cs310.fromfiletodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CS310DBWriter {

	public static void writeListToDB(ArrayList<Student> allStudents) {
	
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "1q2w3e4r");		
			for (Student s : allStudents)
			{
				PreparedStatement ps =  connection.prepareStatement("insert into Students (name,lastname) values (?,?) ");
				ps.setString(1, s.getName());
				ps.setString(2, s.getLastname());
				
				ps.execute();
			}
			
			
			System.out.println("Data inserted!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

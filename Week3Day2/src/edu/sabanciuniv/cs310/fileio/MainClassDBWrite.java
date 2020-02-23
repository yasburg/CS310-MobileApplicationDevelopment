package edu.sabanciuniv.cs310.fileio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClassDBWrite {

	public static void main(String[] args) {
		
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "1q2w3e4r");
			System.out.println("connected!!");
			
			
			//Learn SQL select,insert,update & delete queries
			//PreparedStatement ps =  connection.prepareStatement("insert into Students (name,lastname) values ('Ahmet','Demirelli') ");
			
			PreparedStatement ps =  connection.prepareStatement("update Students set name='Mehmet' where id=3 ");
			
			System.out.println("Statement created");
			
			ps.execute();
			
			System.out.println("Data inserted!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package edu.sabanciuniv.cs310.hw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCManager {

	public static void insertOneEmployee(Employee e1) 
	{
		try 
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","1997");

			PreparedStatement ps =  con.prepareStatement("insert into employee (employeeName) values (?)");
			ps.setString(1, e1.getName());

			int result = ps.executeUpdate();
			
			if(result==1)
			{
				System.out.println("Data inserted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

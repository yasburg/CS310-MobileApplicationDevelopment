package edu.sabanciuniv.cs310.fromfiletodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClassSelect {

	public static void main(String[] args) {
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310", "root", "1q2w3e4r");		
			PreparedStatement ps =  connection.prepareStatement("select id,name, lastname from Students");
			
			ResultSet rs =	ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String n  = rs.getString("name");
				String l  = rs.getString("lastname");
				System.out.println(id + " - " + n + " - "+l);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

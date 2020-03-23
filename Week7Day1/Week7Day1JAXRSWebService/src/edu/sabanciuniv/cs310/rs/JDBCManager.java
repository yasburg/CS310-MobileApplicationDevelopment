package edu.sabanciuniv.cs310.rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCManager {

	public static boolean save(Employee e1) 
	{
		try 
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","1q2w3e4r");
			PreparedStatement ps =  con.prepareStatement("insert into employee (name,lastname) values (?,?)");
			ps.setString(1, e1.getName());
			ps.setString(2, e1.getLastname());
			int result = ps.executeUpdate();
			
			if(result==1)
			{
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Employee> getAll() {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		try 
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cs310", "root","1q2w3e4r");
			PreparedStatement ps =  con.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String n = rs.getString("name");
				String l = rs.getString("lastname");
				int id = rs.getInt("id");
				Employee e = new Employee(n, l);
				e.setId(id);
				
				emps.add(e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emps;
	}

}

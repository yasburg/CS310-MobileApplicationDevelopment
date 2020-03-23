package edu.sabanciuniv.cs310.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("EmployeeWebService")
public class EmployeeWebService 
{
	
	@GET
	@Path("addEmployee/{n}/{ln}")
	public boolean addEmployee(@PathParam("n") String name, 
			@PathParam("ln")String lastName)
	{
		Employee emp = new Employee(name,lastName);
		boolean result =  JDBCManager.save(emp);
		return  result;
	}
	
	@GET
	@Path("getAllEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees()
	{
		ArrayList<Employee> employees = JDBCManager.getAll();
		return employees;
	}

}

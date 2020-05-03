package edu.sabanciuniv.cs310.rs;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sabanciuniv.cs310.domain.Employee;

@Path("EmployeeService")
public class EmployeeService {
	
	@GET
	@Path("getEmployee/{eid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("eid") int id)
	{
		return new Employee(1, "John", "Mac Klein");
	}
	
	@GET
	@Path("getAllEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Employee> getAllEmployees()
	{
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		emps.add( new Employee(1, "John", "Mac Klein"));
		emps.add( new Employee(2, "John", "Two"));
		emps.add( new Employee(3, "John", "Three"));
		emps.add( new Employee(4, "John", "Four"));
		return emps;
	}

}

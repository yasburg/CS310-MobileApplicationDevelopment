package edu.sabanciuniv.cs310.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("CalculatorService")
public class CalculatorService {
	
	@Path("add/{x}/{y}")
	@GET
	public double add(@PathParam("x") double x, @PathParam("y") double y)
	{
		return x+y;
	}
	@Path("multiply/{x}/{y}")
	@GET
	public double multiply(@PathParam("x")double x, @PathParam("y")double y)
	{
		return x*y;
	}
	@Path("subtract/{x}/{y}")
	@GET
	public double subtract(@PathParam("x")double x, @PathParam("y")double y)
	{
		return x-y;
	}
	@Path("divide/{x}/{y}")
	@GET
	public double divide(@PathParam("x")double x, @PathParam("y")double y)
	{
		return x/y;
	}

}

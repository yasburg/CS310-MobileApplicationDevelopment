package edu.sabanciuniv.cs310.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainClass {

	public static void main(String[] args) {
		try 
		{
		
			URL url  =  new URL("http://localhost:8080/Week6Day2-JAX-RS/rest/EmployeeService/getAllEmployees");
			//URL url  =  new URL("http://localhost:8080/Week6Day2-JAX-RS/rest/CalculatorService/multiply/78/78");
			
			InputStreamReader reader = new InputStreamReader(  url.openStream());
			
			BufferedReader rd = new BufferedReader(reader);
			
			while(true)
			{
				String line = rd.readLine();
				if(line==null)
					break;
				System.out.println(line);
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

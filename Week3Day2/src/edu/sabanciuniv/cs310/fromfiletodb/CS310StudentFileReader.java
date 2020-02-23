package edu.sabanciuniv.cs310.fromfiletodb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CS310StudentFileReader 
{
	
	public static ArrayList<Student> readStudentsFromFile(String filename)
	{
		ArrayList<Student> students 
		= new ArrayList<Student>();
		try 
		{
			FileReader reader = new FileReader("students.csv");
			BufferedReader bfr = new BufferedReader(reader);
			while(true)
			{
				String line = bfr.readLine();
				if (line == null)
				{
					break;
				}
				//System.out.println(line);
				String[] arr = line.split(";");
				String lastname = arr[0];
				String name = arr[1];
				Student s = new Student(name, lastname);
				
				students.add(s);
			}
			reader.close();
		
		}
		catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("no have rights to read that file");
			e.printStackTrace();
		}
		return students;
	}

}

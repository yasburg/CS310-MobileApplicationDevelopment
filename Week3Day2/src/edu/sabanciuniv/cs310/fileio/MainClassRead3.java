package edu.sabanciuniv.cs310.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClassRead3 {

	public static void main(String[] args) 
	{
	
		//System.out.println((char)88);
		
		try 
		{
			File file = new File("studyme.txt");
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader is = new InputStreamReader(stream);
			char[] inputArray = new char[(int)file.length()];
			
			is.read(inputArray, 0, (int)file.length());
			System.out.println(inputArray);
			stream.close();
		
		}
		catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("no have rights to read that file");
			e.printStackTrace();
		}

	}

}

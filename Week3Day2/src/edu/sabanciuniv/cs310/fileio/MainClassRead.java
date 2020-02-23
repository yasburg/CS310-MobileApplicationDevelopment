package edu.sabanciuniv.cs310.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClassRead {

	public static void main(String[] args) 
	{
	
		//System.out.println((char)88);
		
		try 
		{
			FileReader reader = new FileReader("studyme.txt");	
			while(true)
			{
				int x = reader.read();
				if (x == -1)
				{
					break;
				}
				System.out.print((char)x);
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

	}

}

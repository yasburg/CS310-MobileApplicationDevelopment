package edu.sabanciuniv.cs310.fileio;

import java.io.FileWriter;
import java.io.IOException;

public class MainClassWrite {

	public static void main(String[] args) {
		
		try
		{
			FileWriter fw = new FileWriter("newFile.txt");
			fw.write("Yasin Aydin");
			fw.flush();
			fw.close();
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

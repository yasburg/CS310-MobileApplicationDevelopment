package edu.sabanciuniv.cs310.exceptionhandling;


public class MainClass {

	public static void main(String[] args) {
		
		try
		{
			double result = Operation.divide(123, 0);
			System.out.println(result);
		}
		catch (Exception e) {
			System.out.println("can not divide to 0");
			e.printStackTrace();
		}
		
		try {
			Operation.danger(-123);
		} catch (AhmetException e) {
			System.out.println("Exception Ahmet!");
			e.printStackTrace();
		}

		try {
			OperationYasin.testOperation("yasin");
		} catch (YasinException e) {
			System.out.println("Exception Yasin!");
			e.printStackTrace();
		}
	}
}

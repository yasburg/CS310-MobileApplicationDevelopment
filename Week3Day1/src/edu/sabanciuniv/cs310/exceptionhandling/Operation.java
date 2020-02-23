package edu.sabanciuniv.cs310.exceptionhandling;

public class Operation {
	
	public static double divide(double x, double y)
	{
		return x / y;
	}
	
	public static int danger(int y) throws AhmetException
	{
		if(y < 0)
		{
			throw new AhmetException();
		}
		return y;
	}

}

package edu.sabanciuniv.cs310.interfaces;

public abstract class Vehicle {
	
	public void start()
	{
		System.out.println("Vehicle started");
	}
	
	public void stop()
	{
		System.out.println("Vehicle stopped");
	}
	
	public abstract void go();
	

}

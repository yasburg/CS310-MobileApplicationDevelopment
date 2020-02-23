package edu.sabanciuniv.cs310.interfaces;

public class ElectricCar extends Vehicle implements ElectronicDevice {

	@Override
	public void charge() {
		System.out.println("Electric car is charged");
		
	}

	@Override
	public void go() {
		
		System.out.println("Car is going");
		
	}

}

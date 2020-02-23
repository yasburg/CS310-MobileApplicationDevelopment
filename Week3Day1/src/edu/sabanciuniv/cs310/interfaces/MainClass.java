package edu.sabanciuniv.cs310.interfaces;

public class MainClass {

	public static void main(String[] args) {
		
		ElectricCar c = new ElectricCar();
		
		c.start();
		
		c.go();
		
		c.stop();
		
		ElectronicDevice e1 = new ElectricCar();
		e1.charge();
		//e1.go();
		//Type (Down) casting
		ElectricCar c1 = (ElectricCar)e1;
		c1.go();
		c1.charge();
		
		
		Vehicle v1 = new ElectricCar();

	}

}

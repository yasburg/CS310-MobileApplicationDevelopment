package edu.sabanciuniv.cs310.overloading.overrriding;

public class B extends A {
	
	//Method overriding
	@Override //This Annotation ensures we override the method correct
	public int methodA(int x, int y) {
		System.out.println("B.methodA runs (2 parameters)");
		return 0;
	}
	
	//Method overloading
	public int methodA(int x, int y,int z) {
		System.out.println("B.methodA runs (3 parameters)");
		return 0;
	}
	
}

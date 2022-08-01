package alchemy.activities;

public class Car {

	String color;
	String transmission;
	int make,tyres, doors;
	
	Car()
	{
		tyres=4;
		doors=4;
	}
	
	public void displaycharacteristics()
	{
		System.out.println("color of the car "+color); 
		System.out.println("the transmission type is "+transmission);
		System.out.println("the make of the car is "+make);
		System.out.println("the no of tyres are "+tyres);
		System.out.println("the number of doors are "+doors); 
	}
	public void accelerate()
	{
		System.out.println("car is moving forward");
	}
	
	public void brake()
	{
		System.out.println("car is stopped");
	}
}

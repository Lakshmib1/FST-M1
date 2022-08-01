package alchemy.activities;

public class Activity1 {

	public static void main(String[] args) {
		Car obj = new Car();
		obj.make = 2014;
		obj.color = "black";
		obj.transmission = "manual";
		obj.displaycharacteristics();
		obj.accelerate();
		obj.brake();
		

	}

}

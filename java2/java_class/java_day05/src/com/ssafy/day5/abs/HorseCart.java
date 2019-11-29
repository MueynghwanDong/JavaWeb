package com.ssafy.day5.abs;

public class HorseCart extends Vehicle{	//The type HorseCart must implement the inherited abstract method Vehicle.addFuel()

	@Override
	public void addFuel() {
		System.out.println("건초 공급");
	}
}
package com.ssafy.day5.abs;

public class VehicleTest {

	public static void main(String[] args) {
		Vehicle[] vehicles = {new ElecCar(), new DieselSUV(), new HorseCart()};
		
		for(Vehicle v : vehicles) {
			v.printPosition();
			v.addFuel();
		}
	}
}

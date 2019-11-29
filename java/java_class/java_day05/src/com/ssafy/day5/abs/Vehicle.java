package com.ssafy.day5.abs;

public abstract class Vehicle {
	public abstract void addFuel();	// abstract 메서드는 선언부만 있고 바디는 없다. 그리고 메서드가 abstarct면 클래스도 abstract가 되어야한다.
									// abstract 메서드는 자식 클래스가 반드시 오버라이드 해서 구현해야 한다.
	public void printPosition() {
		System.out.println("현재 위치 출력");
	}
}

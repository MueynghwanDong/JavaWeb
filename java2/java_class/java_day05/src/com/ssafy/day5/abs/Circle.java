package com.ssafy.day5.abs;

public class Circle extends Shape{
	int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}

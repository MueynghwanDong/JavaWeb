package com.ssafy.day5.abs;

public class Rectangle extends Shape{
	int width;
	int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {
		return width * height;
	}
	
	public int getArea() {
		return 2 * (width + height);
	}
}

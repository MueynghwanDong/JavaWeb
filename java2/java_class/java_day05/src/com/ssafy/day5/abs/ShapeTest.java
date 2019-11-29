package com.ssafy.day5.abs;

public class ShapeTest {

	public static void main(String[] args) {
		// abstarct class는 객체 생성 불가
//		Shape shape = new Shape();
		
		// abstract class는 상속 전용의 클래스
		// 따라서 모든 메서드를 재정의하거나 자신이 abstract가 되야 함
		
		Shape[] shapes = {new Rectangle(10, 10), new Rectangle(1, 2), new Circle(10)};
		
		// 1. 모든 도형의 면적의 합은?
		double sum = 0;
		
		for(Shape s : shapes) {
			sum += s.calcArea();
		}
		
		System.out.println("모든 도형의 면적의 합 : " + sum);
		
		
		// 2. 모든 사각형의 둘레의 합은?
		int round = 0;

		for(Shape s : shapes) {
			if(s instanceof Rectangle) {
				Rectangle r = (Rectangle) s;
				round += r.getArea();
			}
		}
		
		System.out.println("모든 사각형의 둘레의 합 : " + round);
	}
}

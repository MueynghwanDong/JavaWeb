package com.ssafy.day1.variable;

public class VariableTest {

	public static void main(String[] args) {
		// 정수 데이터 사용 시 주의점
		int i = 10;
		System.out.println(i+1);

		int iMax = Integer.MAX_VALUE;		// Integer: wrapper class
		System.out.println(iMax);
		System.out.println(iMax + 1);		// 정수의 overflow. 이런 경우는 error가 나지 않기 때문에 주의해서 사용해야한다.

		// 실수 사용시 주의점 - 실수는 부정확하다. 
		float f1 = 0.12345678901234567890f;
		double d1 = 0.12345678901234567890;

		System.out.println(f1 + " : " + d1);
		
		float f2 = 0.5f;
		double d2 = 0.5;
		System.out.println(f2 + " : " + d2);
		System.out.println(f2 == d2);
	}
}
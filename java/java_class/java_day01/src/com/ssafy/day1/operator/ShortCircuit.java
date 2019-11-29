package com.ssafy.day1.operator;

public class ShortCircuit {

	public static void main(String[] args) {
		int i = 10;
		i += 10;		// i = i + 10
		i -= 10;		// i = i - 10
		System.out.println(i);
		
		int a = 10;
		int b = 20;
		System.out.println((a += 10) > 15 | (b -= 10) > 15);
		System.out.println(a + " : " + b);
		a = 10;
		b = 20;
		
		// || 또는 && 연산자는 하나라도 참 또는 거짓이면 나머지는 무시된다.
		System.out.println((a += 10) > 15 || (b -= 10) > 15);
		System.out.println(a + " : " + b);
	}

}

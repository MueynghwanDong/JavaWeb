package com.ssafy.day5.polymorphism;

public class EqualsTest {

	public static void main(String[] args) {
		Phone p1 = new Phone("010-1234-5678");
		Phone p2 = new Phone("010-1234-5678");
		
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));	// ctrl + Mouse Left Click : 해당 함수 코드로 이동
	}
}

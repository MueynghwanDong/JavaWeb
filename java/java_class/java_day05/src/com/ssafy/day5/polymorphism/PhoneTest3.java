package com.ssafy.day5.polymorphism;

public class PhoneTest3 {
	
	public static void main(String[] args) {
		HandPhone hp = new HandPhone("010-1234-9876", "SKT");
		System.out.println(hp);
		
		Phone phone = hp;
		System.out.println(phone.price);	// 변수는 참조하는 객체의 값을 그대로 사용
		System.out.println(phone);	 // 메서드는 override된 경우 override된 메서드 사용
	}
}

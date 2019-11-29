package com.ssafy.day5.polymorphism;

public class PhoneTest {
	
	public static void main(String[] args) {
		HandPhone hp = new HandPhone();
		
		// 다형성
		Phone phone = hp;
		Object obj = hp;
	
		// 다형성 배열
		HandPhone[] hps = new HandPhone[2];
		hps[0] = hp;
//		hps[1] = new Phone();
		
		Phone[] phones = new Phone[2];
		phones[0] = new Phone();
		phones[1] = hp;
		
		Object[] objs = new Object[5];
		objs[0] = new Object();
		objs[1] = new Phone();
		objs[2] = new HandPhone();
		objs[3] = 3;		// auto boxing -> primitive --> reference 자동 변경 : int --> Integer로 변환
		// 다형성이 적용되는 파라미터
		System.out.println(hp); 	// 다형성을 이용하면 하나의 클래스 타입으로 상속받는 모든 클래스를 매개변수로 받을 수 있다.
	}
}

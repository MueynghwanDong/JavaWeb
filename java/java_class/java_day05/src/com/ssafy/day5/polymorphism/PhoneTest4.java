package com.ssafy.day5.polymorphism;

public class PhoneTest4 {
	
	public static void main(String[] args) {
		HandPhone hp = new HandPhone("010", "SKT");
		DigitalCamera dc = new DigitalCamera();
		
		Object[] objs = {hp, dc};	// Object 클래스를 사용해서 배열에 저장
		
		for(Object obj : objs) {
			if(obj instanceof Chargeable) {
				Chargeable c = (Chargeable) obj;
				c.charge();
			}
		}
		
		
		Chargeable[] cs = {hp, dc};	// 인터페이스를 사용해서 배열에 저장. 훨씬 간단하게 코드를 짤 수 있다.
		
		for(Chargeable c : cs) {
			c.charge();
		}
	}
}

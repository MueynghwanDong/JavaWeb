package com.ssafy.phone;

public class PhoneTest {
	public static void main(String[] args) {
		Battery battery = new Battery(5000, "리튬이온");
		HandPhone hp = new HandPhone("010-3489-7209", 6, battery);
		
		for(int i=0; i < 11; i++) {
			hp.charge(500);
		}
		
		System.out.println("hp: " + hp);
		
		HandPhone hp2 = new HandPhone("010-1234-1234", 8, 6500, "리튬이온");
		hp2.charge(100);
		System.out.println("hp: " + hp2);
	}
}

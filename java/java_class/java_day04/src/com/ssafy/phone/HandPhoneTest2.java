package com.ssafy.phone;

public class HandPhoneTest2 {

	public static void main(String[] args) {
		// 두 개의 전화를 만들어서 전화기 1에서 전화기2로 전화하기.
		HandPhone hp1 = new HandPhone("010-9999-2177", 7, 5500, "리튬이온");
		HandPhone hp2 = new HandPhone("010-3154-1698", 8, 7000, "리튬이온");
		
		hp1.call(hp2.number);
		hp1.call();
		
//		hp2 = hp1;
//		hp1 = null;
//		
//		System.gc();	// Garbage Collection 요청. 하지만 언제 처리될지는 알 수 없다.
		
	}

}

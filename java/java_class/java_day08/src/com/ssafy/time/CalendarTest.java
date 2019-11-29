package com.ssafy.time;

import java.util.*;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		// Date <==> Calendar
		Date d = cal.getTime();
		cal.setTime(new Date());
		
		// 특정 시각 정보 조회 - Calendar의 상수와 get 메서드 이용
		int year = cal.get(Calendar.YEAR);
		System.out.println("올해는 " + year + "년 입니다.");
		int month = cal.get(Calendar.MONTH);
		System.out.println("이번 달은 " + (month+1) + "월 입니다.");	// 월은 0부터 시작. 다른 것은 1부터 시작.
		int min = cal.get(Calendar.MINUTE);
		System.out.println("지금은 " + min + "분 입니다.");
		int sec = cal.get(Calendar.SECOND);
		System.out.println("지금은 " + sec + "초 입니다.");
		
		// 특정 시각으로 변경
		cal.set(Calendar.YEAR, 1000);
		System.out.println("올해는 " + cal.get(Calendar.YEAR) + "년 입니다.");
		
		long calTime = cal.getTimeInMillis();
		long nowTime = new Date().getTime();
		long nowTime2 = System.currentTimeMillis();
		System.out.println( (nowTime - calTime)/1000/60/60/24/365 );
		System.out.println( (nowTime2 - calTime)/1000/60/60/24/365 );
		
	}
}

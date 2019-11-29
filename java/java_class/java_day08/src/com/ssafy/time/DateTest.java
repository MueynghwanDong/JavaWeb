package com.ssafy.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getTime());
		
		// 날짜의 포맷 변경
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd(E)");	// 해당 클래스를 사용하면 날짜의 포맷을 변경할 수 있다.
		String dateStr = format.format(d);
		System.out.println(dateStr);
		
		Date reDate = format.parse(dateStr);
		System.out.println(reDate);
	}
}

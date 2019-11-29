package com.ssafy.day1.operator;

public class OperatorTest {

	public static void main(String[] args) {
		// 증감 연산자
		
		int i = 1;
		i++;	// i = i+1
		i--;	// i = i-1 
		
		System.out.println(i);
		// 전위 연산자 : 무언가 하기 전에 증감 실행
		// 후위 연산자 : 무언가 하고 나서 증감 실행
		System.out.println(++i);
		System.out.println(i++);	
		
		int j = --i;
		System.out.println(j--);
		
		int shifti = 5;
		int shiftj = shifti << 2;
		
		System.out.println(shiftj);
		int shiftk = shiftj >> 1;
		System.out.println(shiftk);
		
		int i2 = 10;
		int i3 = 10;
		// 기본형
		System.out.println(i2 == i3); 		// 두 데이터가 가진 값 비교
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		//참조형
		System.out.println(s1 == s2);				// 주소값 비교
		System.out.println( s1.equals(s2) );		// 실제 내용 비교
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
package com.ssafy.day1.hello;

// 코드의 포맷 : ctrl + shift + f
public class HelloJava {
	// 클래스 영역에 올 수 있는 것은 ? 선언문, 선언문과 함께 쓴 실행문
	// System.out.println("Hello, Java!");		// 해당 실행문은 클래스 영역에서 사용 불가 !
	static int num1 = 10;						// 선언문이라 사용 가능
	
	// java application 시작점
	public static void main(String[] args) {	// 선언문
		// sysout + ctrl + space
		System.out.println("Hello, Java! " + num1);		// 실행문 
		System.out.println(userAgeHahahahahohohoho);	// ctrl + space로 변수명이 길어도 쉽게 참조할 수 있다.
	}
	// 사용자의 나이를 저장하는 변수
	static int num2 = 20;
	
	static int userAgeHahahahahohohoho = 30;	// 요즘 추세, 변수 명에 최대한 설명을 넣는다.
}
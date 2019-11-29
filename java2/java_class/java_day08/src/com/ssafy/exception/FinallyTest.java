package com.ssafy.exception;

import java.util.Scanner;

public class FinallyTest {
	public static void main(String[] args) {
		System.out.println(1);
		Scanner sc = new Scanner(System.in);
		
		try {
//			sc.next();
			
			System.out.println(2);
			int i = 1/0;
			System.out.println(3);
			
		} catch(ArithmeticException e) {
			System.out.println(4);
			return;
		} catch(Exception e) {
			System.out.println(5);
		} finally { 	// 메소드가 리턴되더라도 무조건 실행된 후 리턴된다. 프로그램이 종료되는 케이스 이외에는 무조건 실행. ( 예 : System.exit(0); )
			System.out.println(6);
			
			if(sc != null) 
				sc.close();
		}
		
		
	}
}

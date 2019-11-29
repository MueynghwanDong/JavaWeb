package com.ssafy.exception;

public class SimpleException2 {
	public static void main(String[] args) {
		try {
			int i = 1/0;
		} catch(ArithmeticException e) {
			e.printStackTrace();
		}
		
		System.out.println("종료");
	}
}

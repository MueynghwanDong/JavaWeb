package com.ssafy.exception;

public class SimpleException {
	public static void main(String[] args) {
		try {
			Class.forName("Hello");	// 컴파일러가 검사해주는 예외는 Checked Exception이라고 한다.
		} catch (ClassNotFoundException e) {
//			System.out.println("예외 처리 완료 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
}

package com.ssafy.exception;

import java.io.*;

public class ThrowsTest {
	
	class Inner1 {
		void method() throws IOException {}
	}
	
	class Inner2 extends Inner1 {
		// 부모가 치지 않은 사고를 자식이 칠 수는 없다.
//		void method() throws Exception{}	// 불가능
//		void method() throws IOException{}	// 같은 사고는 가능
		void method() throws FileNotFoundException{}	 //가능
		
	}
	
	public static void main(String[] args) {
		try {
			method();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void method() throws Exception {
		// 임의로 예외 발생시키기
		throw new Exception();
	}
}

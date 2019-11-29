package com.ssafy.exception;

import java.io.*;


public class SImpleException5 {
	public static void main(String[] args) {
		
		try {
			// FileNotFoundException
			FileInputStream fis = new FileInputStream("some");
			
			// IOException
			fis.read();
			
			// 계층 관계에 있는 예외를 처리할 때는 자식이 위에, 부모가 아래로 가야 각각 접근이 가능하다.
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException 처리");
		} catch (IOException e) {
			System.out.println("IOException 처리");
		} catch (Exception e) {
			System.out.println("모든 예외 처리");
		} finally {	// 언제나 실행되는 구문이다.
			System.out.println("언제나 실행");
		}
		
		
	}
}

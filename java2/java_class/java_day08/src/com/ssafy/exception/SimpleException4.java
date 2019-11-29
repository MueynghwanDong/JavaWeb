package com.ssafy.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleException4 {
	public static void main(String[] args) {
		
		try {
			Class.forName("Hello");
			new FileInputStream("some file");
			DriverManager.getConnection("some");
		} catch (ClassNotFoundException e) {	// 예외의 처리 내용이 같을 때
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		
		try {
			Class.forName("Hello");
			new FileInputStream("some file");
			DriverManager.getConnection("some");
			
			// 예외의 처리 내용이 같을 때
		} catch (ClassNotFoundException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
}

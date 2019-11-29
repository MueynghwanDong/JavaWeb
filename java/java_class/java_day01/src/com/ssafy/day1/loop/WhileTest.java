package com.ssafy.day1.loop;

public class WhileTest {

	public static void main(String[] args) {
		int dan = 1;
		
		outer: while(dan < 10) {
			int i = 1;		// 초기화
			
			inner: while(i < 10) {
				if(i == 5) {
					break outer;
				}
				System.out.print(dan + " * " + i + " = " + (dan*i) + "\t");		// 실행문
				i++;		// 증감식
			}
			
			System.out.println();
			dan++;
		}
	}
}
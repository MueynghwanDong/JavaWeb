package com.ssafy.day1.loop;

import java.util.Scanner;

public class ForTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("원하는 구구단의 단을 입력해주세요 >> ");
		//int dan = sc.nextInt();
		
		for(int dan=1; dan <=9; dan++) {
			for(int i=1; i<=9; i++) {
				System.out.print(dan + " * " + i + " = " + dan*i + "\t");
			}
			System.out.println();
		}
	}
}

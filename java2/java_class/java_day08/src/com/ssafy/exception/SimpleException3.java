package com.ssafy.exception;

import java.util.*;

public class SimpleException3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		while(true) {
			System.out.print(" ** 숫자를 입력하세요 >> ");
			
			try {
				num = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.println(" !! 숫자를 입력하셔야 합니다.");
				sc.nextLine();
				continue;
			}
		}
		
		System.out.print(" ** 입력하신 숫자 : " + num);
		
	}
}

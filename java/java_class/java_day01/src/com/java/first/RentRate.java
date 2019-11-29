package com.java.first;

import java.util.Scanner;

public class RentRate {

	public static void main(String[] args) {
		int tradeSel = 0;
		long amount = 0;
		int fee = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" * 거래 내용을 선택해주세요");
		System.out.print("1. 매매 / 2. 임대  >> ");
		
		tradeSel = sc.nextInt();
		
		if(tradeSel < 1 || tradeSel > 2) {
			System.out.println("값을 잘못 입력하셨습니다. ");
			System.out.println("프로그램이 종료됩니다.");
			return;
		}
		
		
		switch(tradeSel) {
		case 1:				// 메메
			System.out.print(" * 금액을 입력해주세요 >> ");
			amount = sc.nextLong();
			
			if(amount <= 0) {
				System.out.println("금액을 잘못 입력하셨습니다.");
				System.out.println("프로그램이 종료됩니다.");
				return;
				
			} else if(0 < amount && amount < 50000000) {
				fee = (int)(amount/1000) * 6;
				
				if(fee > 250000) {
					fee = 250000;
				}
				
			} else if(50000000 <= amount && amount < 200000000) {
				fee = (int)(amount/1000) * 5;
				
				if(fee > 800000) {
					fee = 800000;
				}
				
			} else if(200000000 <= amount && amount < 600000000) {
				fee = (int)(amount/1000) * 4;
				
				
			} else if(600000000 <= amount && amount < 900000000) {
				fee = (int)(amount/1000) * 5;
				
			} else {
				fee = (int)(amount/1000) * 9;
				
			}
			System.out.println("수수료는 " + fee +"원 입니다.");
			break;
			
		case 2:				// 임대 
			System.out.println(" * 금액을 입력해주세요 >> ");
			amount = sc.nextLong();
			
			if(amount <= 0) {
				System.out.println("금액을 잘못 입력하셨습니다.");
				System.out.println("프로그램이 종료됩니다.");
				return;
				
			} else if(0 < amount && amount < 50000000) {
				fee = (int)(amount/1000) * 5;
				
				if(fee > 200000) {
					fee = 200000;
				}
				
			} else if(50000000 <= amount && amount < 100000000) {
				fee = (int)(amount/1000) * 4;
				
				if(fee > 300000) {
					fee = 300000;
				}
				
			} else if(100000000 <= amount && amount < 300000000) {
				fee = (int)(amount/1000) * 3;
				
				
			} else if(300000000 <= amount && amount < 600000000) {
				fee = (int)(amount/1000) * 4;
				
			} else {
				fee = (int)(amount/1000) * 8;
				
			}
			
			System.out.println("수수료는 " + fee +"원 입니다.");
			break;
			
		default:
			break;
		}
	}
}
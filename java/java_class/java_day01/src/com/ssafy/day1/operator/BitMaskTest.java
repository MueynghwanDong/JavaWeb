package com.ssafy.day1.operator;

public class BitMaskTest {
	public static void main(String[] args) {
		int homeElecStatus = 0;		// 0이 32개
		int tvCheck = 0b1;			// 이진수 접두사 0b
		
		String result = "";
		// 삼항 연산자 		boolean ? A : B
		result = (homeElecStatus & tvCheck) > 0 ? "켜짐" : "꺼짐";
		System.out.println(result);
		
		// TV 켜보기
		homeElecStatus |= tvCheck;
		
		// 상태 확인
		result = (homeElecStatus & tvCheck) > 0 ? "켜짐" : "꺼짐";
		System.out.println(result);
		
		// TV 끄기
		homeElecStatus &= ~tvCheck;
		result = (homeElecStatus & tvCheck) > 0 ? "켜짐" : "꺼짐";
		System.out.println(result);
	}
}

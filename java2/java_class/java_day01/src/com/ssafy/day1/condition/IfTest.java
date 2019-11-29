package com.ssafy.day1.condition;

import java.util.Random;

public class IfTest {
	public static void main(String[] args) {
		// 0 ~ 50 까지의 랜덤 정수를 만든 후 그 값이 짝수인지 홀수인지 출력하시오.
		
		Random random = new Random();
		int num = random.nextInt(51);
		
		if(num%2 == 0) {
			System.out.println(num + "은 짝수입니다.");
		}else {
			System.out.println(num + "은 홀수입니다.");
		}
		
		String result = (num%2 == 0) ? "짝수" : "홀수";
		System.out.println(result);
	}
}

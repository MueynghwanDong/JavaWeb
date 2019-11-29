package com.ssafy.day5.object;

public class WrapperTest {

	public static void main(String[] args) {
		// 기본형과 객체형, 문자열의 형변환
		String numStr = "100";
		// 문자열 --> 숫자
		int num = Integer.parseInt(numStr);
		// 숫자 --> 문자열
//		String reStr = String.valueOf(num);
		String reStr = num + "";
		// 숫자 --> 객체
		Integer integer = Integer.valueOf(num);
		Integer integer2 = num;					// autoboxing
		int reNum = integer.intValue();
		int reNum2 = integer2;					// unboxing
	}
}

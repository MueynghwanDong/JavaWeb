package com.ssafy.day2.array;

import java.util.Arrays;

public class SimpleArray2 {
	public static void main(String[] args) {
		// TODO : String 3개를 저장할 배열을 선언/생성하세요.
		String[] strs = new String[3];
		
		// TODO : 위 배열에 Hello Java World 를 저장하세요.
		strs[0] = "Hello";
		strs[1] = "Java";
		strs[2] = "World~~~";
		
		// TODO : 배열의 내용을 단순 출력해보세요.
		System.out.println(Arrays.toString(strs));
		
		// TODO : for-each 문장으로 배열 요소의 길이를 출력하세요.
		// 		  문자열의 길이 출력은 문자열.length()를 사용
		for(String str : strs) {
			System.out.printf("%s: %d\n", str, str.length());
		}
		
		
		// TODO : 몇 번째 요소의 길이가 가장 긴지 출력하세요.
		int maxIndex = 0;
		int maxLength = Integer.MIN_VALUE;
		
		for(int i=0; i<strs.length; i++) {
			int len = strs[i].length();
			
			if(maxLength < len) {
				maxLength = len;
				maxIndex = i;
			}
		}
		
		System.out.printf("가장 긴 요소 > %s: %d\n", strs[maxIndex], maxLength);
		
		// System.arrayCopy() : (소스 배열, 시작 위치, 타겟 배열, 시작 위치, 복사 갯수)
		String[] target = new String[10];
		System.arraycopy(strs, 0, target, 0, strs.length);
		
		System.out.println(Arrays.toString(target));
		
	}
}




















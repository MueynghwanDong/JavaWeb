package com.ssafy.day2.array;

import java.util.Arrays;

public class DebuggingTest {
	static int[] nums = {1,2,3,4,5};
	
	public static void main(String[] args) {
		// TODO 배열의 각 요소를 요소의 제곱으로 변경하고 총 합을 출력하시오.
		int sum = 0;
		
		for(int i=0; i < nums.length; i++) {
			nums[i] = nums[i]*nums[i];
			sum += nums[i];
		}
		
		System.out.printf("배열: %s, 총합: %d", Arrays.toString(nums), sum);
	}
}

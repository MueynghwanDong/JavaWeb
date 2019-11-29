package com.ssafy.day2.array;

import java.math.BigDecimal;
import java.util.Arrays;

public class SimpleArray {

	public static void main(String[] args) {
		// 배열 선언
		int [] nums;
		
		// 배열 생성
		nums = new int[5];
		
		System.out.println(nums);		// 유니크한 nums의 주소 값이 출력이 된다.
		System.out.println(nums[0]);

		// 배열의 각 공간은 변수의 기본 값으로 초기화됨
		nums[0] = 100;
		
		// nums[1] = 0.1; // 배열은 동일한 데이터 타입만 관리 가능
		
		nums[2] = 'A';	// char? char타입은 자동 형변환이 일어나 저장이 가능하다.
		System.out.println((char)nums[2]); 
		
		// 선언 + 생성, 같이한 경우
		int[] nums2 = new int[5];
		
		// 선언 + 생성 + 요소 할당
		int[] nums3 = {1,2,3,4,5};
		
		// 선언은 없고 생성과 요소 할당. 이 때는 일반 객체 선언하듯 new 키워드를 사용하여 할당을 해주어야 한다.
		args = new String[] {"Hello", "Java"};
		
		// 반복문을 통한 배열 접근
		for(int i=0; i <nums3.length; i++) {
			System.out.printf("%d번째 요소: %d\n", i, nums3[i]);
		}
		
		// for-each 문을 통한 배열 접근, 자동으로 요소 탐색 - index 사용 불가
		for(int num : nums3) {
			System.out.printf("%d\n", num);
		}
		
		// 단지 내용만 궁금할 때는...
		System.out.println(Arrays.toString(nums3));
		
		// 배열의 경계 : 0 <= x < 배열.length
		System.out.println(nums[100]); 		// Array Index Out Of Bounds Exception 오류 발생 !
	}
}

















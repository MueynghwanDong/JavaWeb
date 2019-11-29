package com.ssafy.day2.array;

import java.util.Arrays;

public class SimpleArray3 {
	
	public static void main(String[] args) {
		
		int 		num;
		int		[] 	arr;
		int	[]	[] 	arr2;
		
		arr = new int[] {1,2,3};
		// arr2 = new int[][] {1,2,3};		
		arr2 = new int[3][];		// 다차원 배열은 하나 작은 차원의 배열을 관리하는 배열
		arr2[0] = arr;
		
		int[] arr3 = new int[3];
		arr2[1] = arr3;

		int[][] multi1 = {{1,2,3}, {4,5}, {6,7,8,9,10}};
		
		// 크기
		System.out.println(multi1.length);
		// index=2 에 있는 배열의 길이
		System.out.println(multi1[2].length);
		// 0번째 배열의 2번째 요소 출력
		System.out.println(multi1[0][2]);
		
		
		// 정방형의 배열 생성
		int [][] multi2 = new int[4][2];		// multi2의 크기는 4, 관리하는 배열들의 크기는 2
		
		
		// multi1이 가진 모든 int의 합은??
		int sum = 0;
		
		for(int[] ref : multi1) {
			for(int number : ref) {
				sum += number;
			}
		}
		
		System.out.println("multi1 배열 요소들의 총합 : " + sum);
		
		// 배열의 내용을 확인해보자
		System.out.println(Arrays.toString(multi1));
		for(int[] ref : multi1) {
			System.out.println(Arrays.toString(ref));
		}
	}
}

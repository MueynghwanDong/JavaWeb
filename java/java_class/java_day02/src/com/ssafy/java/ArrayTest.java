package com.ssafy.java;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
	static int[] list = {34, 23, 64, 25, 12, 75, 22, 88, 53, 37};
	
	public static void print() {
		System.out.println(Arrays.toString(list));
	}
	
	public static void total() {
		int sum = 0;
		
		for(int num : list) {
			sum += num;
		}
		
		System.out.println("배열 합계 : " + sum);
	}
	
	public static void average() {
		int sum = 0;
		
		for(int num : list) {
			sum += num;
		}
		
		System.out.printf("배열 평균 : %.2f\n", 1.0 * sum/list.length);
	}
	
	public static void minimum() {
		int min = Integer.MAX_VALUE;
		
		for(int num : list) {
			if(min > num) {
				min = num;
			}
		}
		
		System.out.println("최소값 : " + min);
	}
	
	public static void selectionSort() {
		Arrays.sort(list);
		print();
	}
	
	public static void main(String[] args) {
		print();
		total();
		average();
		minimum();
		selectionSort();
	}
}

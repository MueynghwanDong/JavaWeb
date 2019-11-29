package com.ssafy.day2.array;

import java.util.Arrays;
import java.util.Random;

class MyLotto {
	int lo[] = new int[6];
	
	// 로또번호 6개 저장
	
	public void selectLotto() {
		for(int i=0; i<lo.length; i++) {
			lo[i] = uniqueNumber(i);
		}
	}
	
	// 중복되지 않는 값 찾아서 반환
	private int uniqueNumber(int index) {
		int num = 0;
		Random rd = new Random();
		boolean eq = false;
		
		while(true) {
			num = rd.nextInt(45)+1;
			
			for(int i=0; i < index; i++) {
				if(lo[i] == num) {
					eq = true;
					break;
				}
			}
			
			if(!eq) {
				break;
			}
		}
		
		return num;
	}
	
	// 배열 출력
	void print() {
		Arrays.sort(lo);
		System.out.println(" * 로또 당첨 번호는 => " + Arrays.toString(lo));
	}
	
	public static void main(String[] args) {
		MyLotto lotto = new MyLotto();
		
		lotto.selectLotto();
		lotto.print();
		
		System.out.println(lotto);
	}
}
package com.ssafy.java;

public class DigitTest2 {
	public static void main(String[] args) {
		int num = 1;
		
		for(int i=0; i<5; i++) {
			if(i < 3) {
				for(int j=0; j < i; j++) {
					System.out.print("\t");
				}
				for(int j=0; j < 5-2*i; j++) {
					System.out.print(num++ + "\t");
				}
				System.out.println();
			} else {
				for(int j=0; j < 5-(i+1); j++) {
					System.out.print("\t");
				}
				for(int j=0; j < 2*(i+1) - 5; j++) {
					System.out.print(num++ + "\t");
				}
				System.out.println();
			}
		}
	}
}

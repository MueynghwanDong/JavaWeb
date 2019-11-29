package com.ssafy.day1.condition;
import java.util.Random;
import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// month가 몇 일까지 있는지 switch case로 작성하시오
		//int month = 0;
		//Scanner sc = new Scanner(System.in);	// 키보드로부터 데이터 받아들이기
		
		//System.out.print("원하는 달을 입력해주세요 >> ");
		//month = sc.nextInt();

		//month = (int) (Math.random() * 12) + 1;
		//System.out.print("선택된 달 " + month + "월의 일 수 : ");
		
		// 요즘에는 아래와 같이 Random 클래스를 활용하는 것이 더 권장이 된다.
		Random random = new Random();
		int month = random.nextInt(12) + 1;
		System.out.print("선택된 달 " + month + "월의 일 수 : ");
		
		switch(month) {
		case 2:
			System.out.println("29");
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30");
			break;

		default:
			System.out.println("31");
		}
	}

}

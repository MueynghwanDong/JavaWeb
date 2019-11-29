package com.ssafy.java;

import java.util.Random;
import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		int sel = 0;
		int userChoice = 0;
		int comChoice = 0;

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요 >> ");
		sel = sc.nextInt();
		
		int userCount = 0;
		int comCount = 0;

		switch(sel) {
		case 1:
			while(true) {
				System.out.print("가위바위보 중 하나 입력 >> ");
				userChoice = sc.nextInt();

				if(userChoice < 1 || userChoice > 3) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					System.out.println("======================================================");
					continue;
				}

				comChoice = rd.nextInt(3) + 1;
				System.out.println("컴퓨터 선택 : " + comChoice);

				if(userChoice == comChoice) {
					System.out.println("비겼습니다! 다시 입력해주세요." + "(사용자 승 : " 
									+ userCount + " / 컴퓨터 승 : " + comCount + ")");
					System.out.println("======================================================");
					continue;
				}

				if(userChoice == 1 && comChoice == 2) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
					
				} else if(userChoice == 1 && comChoice == 3) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
					
				} else if(userChoice == 2 && comChoice == 1) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
					
				} else if(userChoice == 2 && comChoice == 3) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
					
				} else if(userChoice == 3 && comChoice ==1) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
					
				} else if(userChoice == 3 && comChoice == 2) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
				}
				
				System.out.println("======================================================");

				if(userCount == 3) {
					System.out.println("### 사용자 승!!!");
					return;
				} else if(comCount == 3) {
					System.out.println("### 컴퓨터 승!!!");
					return;
				}

			}

		case 2:
			while(true) {
				System.out.print("가위바위보 중 하나 입력 >> ");
				userChoice = sc.nextInt();

				if(userChoice < 1 || userChoice > 3) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					System.out.println("======================================================");
					continue;
				}

				comChoice = rd.nextInt(3) + 1;
				System.out.println("컴퓨터 선택 : " + comChoice);

				if(userChoice == comChoice) {
					System.out.println("비겼습니다! 다시 입력해주세요." + "(사용자 승 : " 
									+ userCount + " / 컴퓨터 승 : " + comCount + ")");
					System.out.println("======================================================");
					continue;
				}

				if(userChoice == 1 && comChoice == 2) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
				} else if(userChoice == 1 && comChoice == 3) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
				} else if(userChoice == 2 && comChoice == 1) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
				} else if(userChoice == 2 && comChoice == 3) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
				} else if(userChoice == 3 && comChoice ==1) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
				} else if(userChoice == 3 && comChoice == 2) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
				}
				
				System.out.println("======================================================");

				if(userCount == 2) {
					System.out.println("### 사용자 승!!!");
					return;
				} else if(comCount == 2) {
					System.out.println("### 컴퓨터 승!!!");
					return;
				}

			}

		case 3:
			while(true) {
				System.out.print("가위바위보 중 하나 입력 >> ");
				userChoice = sc.nextInt();

				if(userChoice < 1 || userChoice > 3) {
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					System.out.println("======================================================");
					continue;
				}

				comChoice = rd.nextInt(3) + 1;
				System.out.println("컴퓨터 선택 : " + comChoice);

				if(userChoice == comChoice) {
					System.out.println("비겼습니다! 다시 입력해주세요." + "(사용자 승 : " 
									+ userCount + " / 컴퓨터 승 : " + comCount + ")");
					System.out.println("======================================================");
					continue;
				}

				if(userChoice == 1 && comChoice == 2) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
					
				} else if(userChoice == 1 && comChoice == 3) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
					
				} else if(userChoice == 2 && comChoice == 1) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
					
				} else if(userChoice == 2 && comChoice == 3) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
					
				} else if(userChoice == 3 && comChoice ==1) {
					comCount++;
					System.out.println("졌습니다!!! (사용자 승 : " + userCount + " / 컴퓨터 승: "
							+ comCount + ")");
					
				} else if(userChoice == 3 && comChoice == 2) {
					userCount++;
					System.out.println("이겼습니다!!! (사용자 승: " + userCount + " / 컴퓨터 승 : "
							+ comCount + ")");
				}

				System.out.println("======================================================");
				
				if(userCount == 1) {
					System.out.println("### 사용자 승!!!");
					return;
				} else if(comCount == 1) {
					System.out.println("### 컴퓨터 승!!!");
					return;
				}

			}
			
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}
}
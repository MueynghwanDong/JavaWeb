package com.ssafy.day10.thread;

import java.util.Random;

import javax.swing.JOptionPane;

public class WhyThread {
	Long startTime = 0l;
	Long endTime = 0l;
	Integer userInput;
	
	public static void main(String[] args) {
		WhyThread wt = new WhyThread();
		wt.heavyWork();
		wt.makeQuestion();
	}
	
	void heavyWork() {
		new Thread( () -> {
			while(userInput == null) {	// 사용자가 입력이 완료되기 전까지
				endTime = System.currentTimeMillis()/1000;
				System.out.println("소요시간 : " + (endTime - startTime));
			}
		} ).start();
	}
	
	void makeQuestion() {
		startTime = System.currentTimeMillis()/1000;
		Random rand = new Random();
		int num1 = rand.nextInt(9) + 1;
		int num2 = rand.nextInt(9) + 1;
		
		String answer = JOptionPane.showInputDialog(null, String.format("%d * %d = ?", num1, num2));
		userInput = Integer.parseInt(answer);
		System.out.printf("총 소요 시간 : %d, 입력값 : %s, 정답? %b\n", (endTime-startTime), answer, (userInput == num1 * num2));
	}
}

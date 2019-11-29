package com.ssafy.day10.thread;

public class ThreadClock {
	Thread t = new Thread(() -> {
		for(int i=1; i <= 60; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i + "초\n");
		}
	});
	
	public static void main(String[] args) {
		Thread counter = new Thread(() -> {
			for(int i = 1; i<=60; i++) {
				System.out.print(i + "초 ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		counter.start();
	}
}

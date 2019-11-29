package com.ssafy.day10.thread;

public class SimpleThreadTest {
	// 1. Runnable Interface 이용 ==> 아직은 thread 아님
	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
			for (int i = 0; i < 10; i++) {
				System.out.print("%");
			}
		}

	}

	// 2. Thread 클래스 이용
	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
			for(int i = 0; i < 10; i++) {
				System.out.print("#");
			}
		}
	}

	public static void main(String[] args) {
		// Thread 생성 및 사용
		MyThread mt = new MyThread();
		Thread mt2 = new Thread(new MyRunnable());

		// anonymous inner class 이용
		Thread mt3 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				for (int i = 0; i < 10; i++) {
					System.out.print("$");
				}
			}
		});
		
		
		// 람다식 이용
		Thread mt4 = new Thread(() ->  {
			System.out.println(Thread.currentThread().getName());
			for (int i = 0; i < 10; i++) {
				System.out.print("@");
			}
		});


		mt.start();
		mt2.start();
		mt3.start();
		mt4.start();
		System.out.println(Thread.currentThread().getName() + "\n main is over...");	// 현재 쓰레드를 실행하고 있는 메서드의 이름을 보여줌
	}
}



























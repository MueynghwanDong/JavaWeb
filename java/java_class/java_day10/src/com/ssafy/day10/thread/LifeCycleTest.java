package com.ssafy.day10.thread;

public class LifeCycleTest {
	Thread t1 = new Thread(() -> {
		for(int i=0; i < 100; i++) {
			System.out.print(1);
		}
	});
	
	Thread t2 = new Thread(() -> {
		for(int i=0; i < 100; i++) {
			System.out.print(2);
		}
	});
	
	Thread t3 = new Thread(() -> {
		for(int i=0; i < 100; i++) {
			System.out.print(3);
		}
	});
	
	// sleep test
	public void sleepTest() throws InterruptedException {
		t1.start();
		t2.start();
		t3.start();
	
		Thread.sleep(1000);		// 이 메서드를 호출한 thread는 주어진 시간동안 대기
	}

	// join test
	public void joinTest() throws InterruptedException {
		t1.start();
		t2.start();
		t3.start();
		t1.join();				// t1의 작업이 종료될 때까지 이 메서드를 호출한 thread (main thread) 대기.
	}			
	
	// interrupt test
	public void interruptTest() throws InterruptedException {
		Thread sleepy = new Thread(() -> {
			// override 상황 ==> 조상 메서드는 예외를 던지지 않더라 ! 그래서 자식도 예외 던지기 불가능ㄴ
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("sleepy 종료");
		});
		sleepy.start();
		Thread.sleep(1000 * 5);
		sleepy.interrupt();
	}
	
	// 종료
	boolean flag = true;
	public void stopBad() throws InterruptedException {
		Thread t = new Thread(() -> {
			System.out.println("중요 자원 획득...");
			while(flag) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("자원 사용.\t");
			}
			System.out.println("자원 반납.");
		});
		t.start();
		
		Thread.sleep(1000);
//		t.stop();		// 스레드는 강제 종료 금지 !! 종료하는 상황을 만들어서 안정적인 작업 종료 환경을 구축해야 한다.
		flag = false;
	}
	
	public static void main(String[] args) throws InterruptedException {
		LifeCycleTest lct = new LifeCycleTest();
//		lct.sleepTest();
//		lct.joinTest();
//		lct.interruptTest();
		lct.stopBad();
		System.out.println("\n main is over...");
	}
}



















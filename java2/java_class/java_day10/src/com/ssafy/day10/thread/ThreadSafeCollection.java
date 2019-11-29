package com.ssafy.day10.thread;

import java.util.*;

public class ThreadSafeCollection {
	
	public static void test(List<Integer> list) throws InterruptedException {
		long start = System.currentTimeMillis();
		// 1부터 100까지 list에 저장하는 runnable 객체 
		Runnable r = () -> {
			for(int i=0; i<100; i++) {
				list.add(i);
			}
		};
		
		// runnable ==> thread
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		long end = System.currentTimeMillis();
		
		System.out.println(list.getClass()+" : " + (end-start) + ", " + list.size());
	}
	
	public static void main(String[] args) throws InterruptedException {
		test(new Vector<>());									// thread safe, but slow
//		test(new ArrayList<>());								// thread safe X, fast
		test(Collections.synchronizedList(new ArrayList<>()));	// thread safe, fast
	}
}

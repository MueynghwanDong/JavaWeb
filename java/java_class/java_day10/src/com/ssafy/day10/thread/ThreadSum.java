package com.ssafy.day10.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadSum {
	public long heavyWork(int th) {
		long result = 0;
		
		for(int i=0; i < Integer.MAX_VALUE; i++) {
			result += i;
		}
		System.out.printf("%d 번째 작업 종료 : %d\n", th, result);
		
		return result;
	}
	
	public void sumByNormal() {
		long first = System.currentTimeMillis();
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += heavyWork(i);
		}
		long second = System.currentTimeMillis();
		System.out.printf("일반작업 총 소요시간: %d, 결과: %,d\n", (second-first), result);
	}
	long result = 0l;
	
	
	public void sumByThread() {
		List<SumThread> list = new ArrayList<>();
		long first = System.currentTimeMillis();
		for(int i = 0; i < 10; i++) {
			SumThread st = new SumThread(i);
			list.add(st);		// 전체적으로 join처리를 위해 list에 담게되었다.
			st.start();
		}
		
		for(SumThread st : list) {
			try {
				st.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long second = System.currentTimeMillis();
		System.out.printf("스레드작업 총 소요시간: %d, 결과: %,d\n", (second-first), result);
	}
	
	class SumThread extends Thread {
		int th = 0;
		public SumThread(int th) {
			this.th = th;
		}
		
		@Override
		public void run() {
			add(heavyWork(th));
		}
	}
	
	// 한번에 하나의 스레드만 더하기 가능
	public synchronized void add(long part) {
		result += part;
	}
	
	public static void main(String[] args) {
		ThreadSum tsum = new ThreadSum();
		tsum.sumByNormal();
		tsum.sumByThread();
	}
}

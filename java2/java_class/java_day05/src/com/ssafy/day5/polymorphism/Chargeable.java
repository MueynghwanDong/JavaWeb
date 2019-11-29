package com.ssafy.day5.polymorphism;

public interface Chargeable {
	// 1. 모든 변수는 public static final
	public static final int A = 10;
	int b = 20;		// 생략 가능
	
	
	// 2. 모든 메서드는 public abstract
	public abstract void methodA();
	void charge();	// 생략 가능
}

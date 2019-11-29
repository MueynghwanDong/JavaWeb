package com.ssafy.day7.inter;

public interface DefaultMethodInterface {
	void methodA();		// 일반적인 인터페이스의 추상 메소드
	
	static void staticMethod() {	// 인터페이스에는 추상 메소드 이외에 static, default 메소드도 올 수 있다.
									// 일반적인 경우는 아니지만 추상 메소드로 만들면 참조하는 모든 클래스가
									// 오버라이딩을 의무적으로 해야하기에 예외로 두기 위해 허용하게 되었다.
		System.out.println("static method");
	}
	
	default void defalutMethod() {
		System.out.println("default method");
	}
}

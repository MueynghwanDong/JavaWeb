package com.ssafy.modifier;

// singleton의 대상: 멤버 변수가 별 의미가 없고 기능만 의미있을 때
//					 stateless 하다 !! <--> stateful (객체의 상태가 의미가 큰 경우)
public class SingletonTeacher {
	// 내부에서 객체 생성 
	private static SingletonTeacher st = new SingletonTeacher("홍길동");
	// private member에 접근하는 메서드 --> 객체 생성없이 접근하도록 static 처리
	public static SingletonTeacher getTeacher() {
		return st;
	}
	
	private String name;
	
	private SingletonTeacher(String name) {
		this.name = name;
	}
	
	public void teach() {
		System.out.println(name + "이 열심히 가르친다." + this);
	}
}

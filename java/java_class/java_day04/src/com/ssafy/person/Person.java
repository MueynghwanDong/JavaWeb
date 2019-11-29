package com.ssafy.person;

public class Person {
	// class member 변수, static member 변수
	static String scientificName;	
	// instance member 변수
	private String name;
	private int age;
	
	// 생성자 - 멤버 변수의 초기화 역할
//	public Person() {}	// 기본 생성자
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void walk() {
		walk(100);
	}
	
	public void walk(int cm) {
		walk(cm, "cm");
	}
	
	public void walk(int cm, String unit) {
		if(unit.equals("inch")) {
			cm = (int) (2.54 * cm);
		}
		
		System.out.println(cm + "cm 이동");
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name != null) {
			this.name = name;
		} else {
			System.out.println("name 속성은 not null");
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		} else {
			System.out.println("age 속성은 0보다 커야합니다.");
		}
	}
}
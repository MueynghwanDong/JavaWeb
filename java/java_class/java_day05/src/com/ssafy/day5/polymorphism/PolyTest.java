package com.ssafy.day5.polymorphism;

import com.ssafy.day5.inheritance.Person;

public class PolyTest {

	public static void main(String[] args) {
		String str = "Hello";
		Person p = new Person("홍길동");
		int num = 100;
		// 위 3개의 자료를 저장하기 위한 배열을 만들고 자료를 저장하시오.
		
		Object[] objs = {str, p, num};
		
		// 각 요소의 실제 타입은?
		for(Object obj : objs) {
			System.out.println(obj + " : " + obj.getClass().getName());
			
			if(obj instanceof Person) {
				Person p2 = (Person)obj;
				
				System.out.println(p2.getName());
			}
				
		}
	}
}

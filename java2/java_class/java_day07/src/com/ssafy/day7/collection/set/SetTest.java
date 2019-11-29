package com.ssafy.day7.collection.set;

import java.util.*;

public class SetTest {
	private Set<String> set = new HashSet<>();
	private Set<HandPhone> set2 = new HashSet<>();
	
	public void addTest2() {
		set2.add(new HandPhone("010", 100));
		set2.add(new HandPhone("010", 100));
		set2.add(new HandPhone("010", 100));
		set2.add(new HandPhone("010", 100));
		
		System.out.println(set2);
	}
	
	public void addTest() {
		set.add("Hello");
		set.add("Java");
		set.add("World");
		set.add("Java");		// 동일한 데이터 추가 X, 기준 : equals()와 hashCode()
		
		System.out.println(set);	// 순서가 없고 동일한 데이터도 추가되지 않는다.
	}
	public void updateTest() {
		// set은 수정을 할 수 없습니다.
	}	
	public void getTest() {
		System.out.println("크기 : " + set.size());
		System.out.println("포함여부 : " + set.contains("Hello"));
	
		// 모든 요소에 대한 순차 접근
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			// 넣을 때는 맘대로, 뺄 때는 only object.	Polymorphism이 적용됨. 다형성
			Object obj = iter.next();
			System.out.println(obj);
		}
		
		int sum = 0;
		
		for(Object obj : set) {
			if(obj instanceof String) {
				String str = (String) obj;
				sum += str.length();
			}
		}
		
		System.out.println("모든 문자열의 길이의 합 : " + sum);
	}
	public void deleteTest() {
		System.out.println("삭제 전 : " + set);
		set.remove("Java");	// 특정 요소 제거
		System.out.println("삭제 후 : " + set);
		
		set.clear();	// set이 가지고 있는 모든 요소를 제거한다.
		System.out.println("초기화 후 : " + set);
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		
		st.addTest();
		st.addTest2();
		st.getTest();
		st.deleteTest();
	}
}

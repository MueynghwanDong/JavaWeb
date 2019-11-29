// 자동적으로 만들어주는 모든 것들을 다 적어본 코드

package com.ssafy.day5.polymorphism;
import java.lang.*;	// 1 이런거

public class Phone extends Object{
	String number;
	int price = 1000;
	
	// 2 이런거 등등
	public Phone() {
		super();
	}
	
	public Phone(String number) {
		this.number = number;
	}
	
	public void call(String number) {
		System.out.println(this.number + "에서 " + number + "에 전화");
	}

	@Override
	public String toString() {
		return "전화번호 : " + number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Phone) {
			Phone other = (Phone)obj;
			
			return this.number == other.number;
		} else {
			return false;
		}
	}
	
	
	
}

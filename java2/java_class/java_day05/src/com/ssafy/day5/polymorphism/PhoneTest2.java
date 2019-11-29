package com.ssafy.day5.polymorphism;

public class PhoneTest2 {
	
	public static void main(String[] args) {
		HandPhone hp = new HandPhone();
		System.out.println(hp.comm);
		System.out.println(hp.number);
		
		Phone phone = hp;	// 자동 형 변환
//		System.out.println(phone.comm);
		System.out.println(phone.number);
		
		Object obj = hp;
//		System.out.println(obj.number);
		
		HandPhone hp2 = (HandPhone)obj;
		System.out.println(hp2.comm);
		
		Phone phone2 = new Phone();
		
		if(phone2 instanceof HandPhone) {	// 런타임시 객체의 실 타입 확인
			HandPhone hp3 = (HandPhone)phone2;	// phone2는 HandPhone이 아니라 Phone이기 떄문에 HandPhone 객체에 할당할 수 없다.
		} else {
			System.out.println("핸드폰 아니에요.");
		}
		
	}
	
	// 전화할 때 가장 적합한 메서드의 선언은 무엇?
	public void call(HandPhone hp) {
		hp.call("123");
	}
	public void call(Phone phone) {
		phone.call("123");
	}
	public void call(Object obj) {
		if(obj instanceof Phone) { // instanceof 연산자는 객체의 실제 타입을 확인해준다
			Phone p = (Phone) obj;
			p.call("123");
		}
	}
	
}

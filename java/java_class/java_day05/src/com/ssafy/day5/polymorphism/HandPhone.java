package com.ssafy.day5.polymorphism;

public class HandPhone extends Phone implements Chargeable{
	
	String comm;
	private String lastCall;
	
	public HandPhone() {
		super();
	}
	
	public HandPhone(String number, String comm) {
		super(number);
		this.comm = comm;
	}
	
	public void sendSMS(String to, String msg) {
		System.out.println(number + "에서 " + to + "에게 " + msg +"를 전송함.");
	}
	
	@Override
	public void call(String number) {
		this.lastCall = number;
		super.call(number);
	}
	
	// method overloading
	public void call() {
		if(lastCall != null)
			call(lastCall);
		else
			System.out.println("저장된 번호가 없습니다.");
	}

	@Override
	public String toString() {
		return super.toString() + ", 통신사: " + comm;
	}

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void charge() {
		// TODO Auto-generated method stub
		System.out.println("핸드폰 충전중...");
	}

	
}
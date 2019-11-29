package com.ssafy.day10.banking;

public class WithdrawThread extends Thread {
	// 공유 자원
	Account account;
	
	public WithdrawThread(String name, Account account) {
		super(name);		// 스레드 이름 설정.
		this.account = account;
	}
	
	@Override
	public void run() {
		while(true) {
			int balance =  account.withdraw(1000);
//			if(balance < 1000) {
//				break;
//			}
		}
	}
}

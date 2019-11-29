package com.ssafy.day10.banking;

public class DepositThread extends Thread {
	Account account;
	
	public DepositThread(String name, Account account) {
		super(name);		// 스레드 이름
		this.account = account;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.deposit(5000);
		}
	}
	
	
	
	
}

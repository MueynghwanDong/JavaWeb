package com.ssafy.day10.banking;

public class AccountSync extends Account {
	int balance;	// 잔액

	public AccountSync(int balance) {
		super(balance);
	}
	
	public synchronized int withdraw(int money) {
		System.out.println(Thread.currentThread().getName()+"의 출금");
		
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			balance -= money;
			System.out.println("출금 완료, 잔액 : " + balance);
		} else {
			System.out.println("잔액 부족으로 출금 불가.");
		}
		
		return balance;
	}
	public synchronized int deposit(int money) {
		System.out.println(Thread.currentThread().getName()+"의 입금");
		this.balance += money;
		return this.balance;
	}
}

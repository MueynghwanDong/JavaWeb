package com.ssafy.day10.banking;

public class MyBanking {
	public static void main(String[] args) {
//		Account account = new AccountSync(5000);
		Account account = new AccountWait(5000);
		
		WithdrawThread t1 = new WithdrawThread("텔레뱅킹", account);
		t1.start();
		
		WithdrawThread t2 = new WithdrawThread("인터넷뱅킹", account);
		t2.start();
		
		DepositThread t3 = new DepositThread("은행창구", account);
		t3.start();
		
		
	}
}

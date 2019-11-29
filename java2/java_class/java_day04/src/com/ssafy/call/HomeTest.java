package com.ssafy.call;

public class HomeTest {
	
	public void increase(int prev) {
		prev += 100;
	}
	public void increase(Home home) {
		home.setArea(home.getArea() + 100);
	}
	
	public static void main(String[] args) {
		Home home = new Home(100);
		System.out.println("home의 초기 크기 : " + home.getArea());
		
		HomeTest ht = new HomeTest();
		ht.increase(home.getArea());
		
		ht.increase(home);
	}
}		
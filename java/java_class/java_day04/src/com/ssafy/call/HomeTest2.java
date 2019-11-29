package com.ssafy.call;

public class HomeTest2 {
	Home[] homes = {new Home(10), new Home(20)};
	
	public static void main(String[] args) {
		// 각 집의 면적을 출력하세요.
		HomeTest2 ht2 = new HomeTest2();
		HomeTest ht = new HomeTest();
		
		for(Home home : ht2.homes) {
			System.out.println(home.getArea());
		}
		
		// HomeTest 의 increase를 이용해 집의 면적을 +100 시켜보자.
		for(Home home : ht2.homes) {
			ht.increase(home);
		}
		
		for(Home home : ht2.homes) {
			System.out.println(home.getArea());
		}
	
	}
}

package com.ssafy.day5.inheritance;

public class SpiderManTest {
	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan("피터 파커", false);
		sman.setName("피터 파커");	// 조상 멤버에 접근
//		sman.hiddenMoney = 100;		// 단 private 제외
//		sman.someProp = 100;
		
		sman.isSpider = true;
		sman.jump();
		
		System.out.println(sman.toString());
	}
}
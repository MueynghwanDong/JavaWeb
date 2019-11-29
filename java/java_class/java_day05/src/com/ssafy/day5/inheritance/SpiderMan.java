package com.ssafy.day5.inheritance;

public class SpiderMan extends Person { // is a 상속 관계
	boolean isSpider;
	Spider spider = new Spider();			// has a 상속 관계
	int age = 100;

	// Method override : 조상이 물려준 메서드를 창조적으로 계승 & 발전 가능	
	@Override		// @ Annotaion, Override를 제대로 했는지 체크해주는 annotaion
	public void jump() {		// The method jamp() of type SpiderMan must override or implement a supertype method
		if(isSpider) {
			spider.jump();
		} else {
			super.jump();
		}
	}

	public SpiderMan(String name, boolean isSpider) {
		super(name);					// super() : 조상 생성자 호출, 생성자 첫 줄에서만 사용 가능(this(), super() 혼용불가)
		this.isSpider = isSpider;
	}

	public void printAge() {
		//		int age = 10;
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
	}

	void fireWeb() {
		spider.fireWeb();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " : " + isSpider;
	}

}
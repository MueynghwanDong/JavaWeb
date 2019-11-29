package com.ssafy.day7.collection.sort;

public class InnerTest {
	private int member;
	
	public void method() {
		Inner1 i1 = new Inner1();
		Inner2 i2 = new Inner2();
		
		// local inner class
		class Inner3{}
		Inner3 i3 = new Inner3();
		
		class MyComp implements Comparable<MyComp> {

			@Override
			public int compareTo(MyComp o) {
				// TODO Auto-generated method stub
				return 0;
			}
		}
		MyComp c = new MyComp();
		// anonymous inner class
		Comparable<String> c2 = new Comparable<String>() {	// 익명 이너 클래스.

			@Override
			public int compareTo(String o) {
				return 0;
			}
		};
	}
	
	public static void main(String[] args) {
		InnerTest it = new InnerTest();
		Inner1 i1 = it.new Inner1();
		Inner2 i2 = new Inner2();
	}
	
	class Inner1{
		public void method() {
			member = 100;	// inner에서 외부 클래스의 private member에 접근 가능
		}
	}
	static class Inner2{}
}

package com.ssafy.day5.modifier;

public class Parent {
	private int privateMember;
	int defaultMember;
	protected int protectedMember;
	public int publicMember;
	
	public void method() {
		this.privateMember = 100;
		this.defaultMember = 1000;
		this.protectedMember = 10000;
		this.publicMember = 100000;
	}
}

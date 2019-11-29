package com.ssafy.day7.inter;

import java.util.*;

public class DefaultMethodTest implements DefaultMethodInterface{

	@Override
	public void methodA() {
		System.out.println("override method");
	}
	
	public static void main(String[] args) {
		DefaultMethodInterface.staticMethod();
		
		DefaultMethodInterface dmi = new DefaultMethodTest();
		dmi.defalutMethod();
		dmi.methodA();
	}
}
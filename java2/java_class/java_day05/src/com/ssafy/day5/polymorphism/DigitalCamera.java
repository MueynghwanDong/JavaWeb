package com.ssafy.day5.polymorphism;

import java.io.Serializable;

public class DigitalCamera implements Chargeable, Serializable{ 	// Serializable 인터페이스는 Markable 인터페이스로 따로 구현해야하는 메서드가 없다.

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void charge() {
		// TODO Auto-generated method stub
		System.out.println("디카 충전중...");
	}

}

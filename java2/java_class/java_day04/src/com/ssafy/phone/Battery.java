package com.ssafy.phone;

public class Battery {
	int capacity;
	int current;
	String type;
	
	public Battery() {}
	
	public Battery(int capacity, String type) {
		this.capacity = capacity;
		this.type = type;
	}
	
	// 충전량이 capacity를 넘지 못하도록 처리하시오.
	public void charge(int elec) {
		if(current + elec >= capacity) {
			System.out.println("배터리 완충.. 더 이상 충전 불가...");
			this.current = capacity;
		} else {
			this.current += elec;
			System.out.println("배터리 충전중 : " + (current+elec));
		}
		
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
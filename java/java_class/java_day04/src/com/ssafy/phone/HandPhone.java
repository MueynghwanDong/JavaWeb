package com.ssafy.phone;

public class HandPhone {
	String number;
	int width;
	Battery battery;
	String lastCallNumber;
	
	public HandPhone() {}
	

	public HandPhone(String number, int width) {
		this.number = number;
		this.width = width;
		this.battery = new Battery(3000, "type");
	}
	
	public HandPhone(String number, int width, Battery battery) {
		this(number, width);
		this.battery = battery;
	}
	
	public HandPhone(String number, int width, int capacity, String type) {
		this(number, width);
		this.battery = new Battery(capacity, type);
	}


	// 핸드폰은 배터리를 충전한다.
	public void charge(int elec) {
		System.out.println("charge의 this: " + this);
		battery.charge(elec);
	}
	
	/**
	 * number에게 전화를 건다.
	 * @param number
	 */
	
	// method overloading: 메서드 이름이 같고 파라미터는 다르다. 
	//						외워야할 메서드가 줄어들고, 중복된 코드를 제거할 수 있다.
	public void call(String number) {
		String beep = "띠~ ";
		
		for(int i=0; i<3; i++) {
			System.out.print(beep + "\n");
		}
		
		System.out.println(this.number + "에서 " + number + "에게 전화함.");
		
		lastCallNumber = number;
	} 
	
	public void call() {
		if(lastCallNumber != null) {
			call(lastCallNumber);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

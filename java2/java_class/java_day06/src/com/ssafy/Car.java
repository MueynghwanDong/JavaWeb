package com.ssafy;

public class Car {
	static final int NUM_LENGTH = 7;
	static final int BASE_PRICE = 5000000;
	
//	num은 7자리의 문자열로 구성되어야 한다.
	private String num;
//	model은 null이 될 수 없다.
	private String model;
//	금액은 500만원 이상이다.
	private int price;
	
	public Car() {}
	public Car(String num, String model, int price) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
	}
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		if(num.length() != NUM_LENGTH) 
			System.out.printf("차량 번호는 %d자리입니다.\n", NUM_LENGTH);
		else
			this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		if(model == null)
			System.out.println("null 객체입니다. 유효한 객체를 사용하세요.");
		else
			this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < BASE_PRICE)
			System.out.printf("차량의 금액은 %,d만원 이상이어야 합니다.\n", BASE_PRICE);
		else
			this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Car [num=" + num + ", model=" + model + ", price=" + price + "]";
	}
}

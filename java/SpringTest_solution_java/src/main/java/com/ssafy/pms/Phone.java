package com.ssafy.pms;

public class Phone {
	private String num;
	private String model;
	private int price;
	private String vcode;
	
	Company comp;

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	public Phone() {
	}

	public Phone(String num, String model, int price, String vcode) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
		this.vcode = vcode;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	@Override
	public String toString() {
		return "Phone [num=" + num + ", model=" + model + ", price=" + price + ", vcode=" + vcode + ", comp=" + comp
				+ "]";
	}



}
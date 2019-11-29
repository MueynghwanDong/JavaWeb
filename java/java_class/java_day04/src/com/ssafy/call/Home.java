package com.ssafy.call;
// import

public class Home {
	private int area;	// 집의 면적: 양수만..

	public Home() {}
	public Home(int area) {
		this.area = area;
	}
	
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		if(area >= 0) {
			this.area = area;
		}
	}
}
package com.ssafy.day7.collection.set;

public class HandPhone implements Comparable<HandPhone> {
	public String number;
	public int price;
	
	public HandPhone() {
		super();
	}
	public HandPhone(String number, int price) {
		super();
		this.number = number;
		this.price = price;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HandPhone other = (HandPhone) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "HandPhone [number=" + number + ", price=" + price + ", hashCode()=" + hashCode() + "]";
	}
	
	@Override
	public int compareTo(HandPhone o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.price).compareTo(Integer.valueOf(o.price));
	}
}
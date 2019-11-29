package com.ssafy.io;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	UserInfo info = new UserInfo();
	
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", info=" + info + "]";
	}
}

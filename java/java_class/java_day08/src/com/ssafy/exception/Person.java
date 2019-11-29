package com.ssafy.exception;

public class Person {
	private String name;
	private int age;
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0) {
			throw new NegativeAgeException(age);	// RuntimeException 계열은 별도로 thorws를 해주지 않아도 잘 넘어간다.
		}
		
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws ValueIsNullException {
		if(name == null) {
//			System.out.println("name is null");
			throw new ValueIsNullException("name");
		} else {
			this.name = name;
		}
	}
	
	
}

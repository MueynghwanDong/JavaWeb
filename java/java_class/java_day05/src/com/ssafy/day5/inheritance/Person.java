package com.ssafy.day5.inheritance;

public class Person {
	private String name;
	int age = 1000;
	private String hiddenMoney;
	
	public Person() {}		// implicit super constructor Person() is undefined for default constructor. Must define an explicit constructor
	
	public Person(String name) {
		this.name = name;
	}
	
	public void jump() {
		System.out.println("두 다리로 폴짝!");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", hiddenMoney=" + hiddenMoney + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((hiddenMoney == null) ? 0 : hiddenMoney.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (hiddenMoney == null) {
			if (other.hiddenMoney != null)
				return false;
		} else if (!hiddenMoney.equals(other.hiddenMoney))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
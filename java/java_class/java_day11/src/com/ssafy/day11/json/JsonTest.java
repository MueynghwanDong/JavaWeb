package com.ssafy.day11.json;

import com.google.gson.Gson;

public class JsonTest {
	public static void main(String[] args) {
		Person p = new Person("홍진호", 22);
		
		// Gson : 객체 <=> Json 간의 변환
		Gson gson = new Gson();
		String gsonStr = gson.toJson(p);
		
		System.out.println(gsonStr);
		
		Person rePerson = gson.fromJson(gsonStr, Person.class);
		System.out.println(rePerson);
	}

	static class Person {
		private String name;
		private int age;

		public Person() {
		}
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

		
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	}
}

package com.ssafy.person;

public class PersonTest {
	
	public static void main(String[] args) {
		Person.scientificName = "호모사피엔스";
		// Person.name
		Person p1 = new Person("홍길동", 10);	// The constructor Person() is undefined
//		p1.name = "홍길동";

		Person p2 = new Person("임꺽정", 20);
//		p2.name = "임꺽정";
		
		System.out.println(p1.getName());
		// Warning이 나는 이유는 static 변수를 클래스를 통해 접근하지 않고 객체로 접근했기 때문이다.
		// The static field Person.scientificName should be accessed in a static way
		System.out.println(p1.scientificName);
		p2.scientificName = "호모데우스";
		System.out.println(p1.scientificName);
		
		p1.setName(null);
		p1.setAge(-10);
		
		System.out.println(p1.getName() + " : " + p1.getAge());
	}
	
	
}
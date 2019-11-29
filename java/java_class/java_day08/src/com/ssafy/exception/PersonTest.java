package com.ssafy.exception;

public class PersonTest {
	public static void main(String[] args) {
		
		try {
		Person p = new Person();
		
		p.setName("홍길동");
		System.out.println(p.getName());
		
		p.setName(null);
		
		} catch (ValueIsNullException e) {
			System.out.println(e.getMessage());
		}
		
		
		Person p2 = new Person();
		p2.setAge(-10);
		
		/*
		 * Checked Exception은 별도의 예외처리를 무조건 해 줘야 컴파일이 되지만
		 * Runtime Exception계열은 별도로 예외처리를 해주지 않아도 된다.
		 * 
		 * Runtime Exception은 코드가 간결해진다는 장점이 있지만, 주의해서 코드를 작성하지 않으면 예외 상황에서도 예외인 것을 인지하기 힘들 때가 있다.
		 * 반대로 Checked Exception은 코드는 다소 지저분해 보일 수 있지만, 예외처리를 확실하게 해 줄수 있기 때문에 각각 장단이 있다고 할 수 있다.
		 * */
		
	}
}

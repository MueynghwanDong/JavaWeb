package com.ssafy.day5.object;

public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println( (s1==s2) + " : " + (s1.equals(s2)) );
		
		// new 연산자를 사용하지 않고 아래처럼 만들면 스트링 풀에 따로 저장된다. 있으면 새로 만들지 않고 재사용한다.
		String s3 = "Hi";
		String s4 = "Hi";
		System.out.println( (s3==s4) + " : " + (s3.equals(s4)) );
		
		String a = "A";
		a = a + "B" + "C";		// 이런 코드는 내부적으로 객체를 따로 생성해 메모리를 많이 잡아 먹는다. 그래서 최대한 피해야 하는 코드.
		
		// String은 가급적 읽을 떄만 사용, 그 외에는 StringBuilder를 이용해 처리하자.
		StringBuilder sb = new StringBuilder("A");
		sb.append("B").append("C");
		
		System.out.println(sb);
	}
}

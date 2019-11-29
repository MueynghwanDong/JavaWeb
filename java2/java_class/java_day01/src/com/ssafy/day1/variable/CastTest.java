package com.ssafy.day1.variable;

public class CastTest {
	public static void main(String[] args) {
		// promotion - 묵시적 형변환
		char c = 'A';	// 숫자 --> 문자로 매핑 A: 65
		
		// 연산시의 형 변환: int 이하의 것들 --> 무조건 int
		System.out.println(c + " : " + (c+1));
		
		// 기본형 - 자기가 값을 갖는다 ! !
		long l1 = 1l;
		double d1 = 1.0;
		
		// 형변환은 데이터의 크기와는 무관, 타입과 유관
		int i1 = (int) l1;	// Type mismatch: cannot convert from long to int
		
		// 연산시 형 변환2: int 이상의 것들 --> 큰 것의 타입
		double d2 = l1 + d1;
		
		int i2 = Integer.MAX_VALUE;
		long l2 = (long)i2 + 1;
		System.out.println(l2);
		
		// 우선순위에 따라서, 같은 결과값이더라도 overflow가 발생할 수 있다.
		int i3 = 1000000 * 1000000 / 1000000;
		int i4 = 1000000 / 1000000 * 1000000;
		System.out.println("i3 : " + i3 + "\ni4 : " + i4);
		
		System.out.println(i1 + d2);
	}
}


















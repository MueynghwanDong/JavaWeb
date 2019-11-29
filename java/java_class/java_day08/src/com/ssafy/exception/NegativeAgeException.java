package com.ssafy.exception;

public class NegativeAgeException extends RuntimeException {	// RuntimeException은 CheckedException이랑 다르게 동작한다.
	public NegativeAgeException(int age) {
		super("나이는 양의 정수여야 합니다 : " + age);
	}
}
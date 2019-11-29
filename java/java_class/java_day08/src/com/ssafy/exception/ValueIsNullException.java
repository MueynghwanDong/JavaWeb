package com.ssafy.exception;

public class ValueIsNullException extends Exception {	// 그냥 Exception을 상속받고 있기 때문에 Checked Exception
	public ValueIsNullException(String column) {
		super(column + "은 null이라 불가능합니다. ");
	}
}

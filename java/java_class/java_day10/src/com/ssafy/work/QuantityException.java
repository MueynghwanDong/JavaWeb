package com.ssafy.work;

public class QuantityException extends Exception {
	public QuantityException(int quantity) {
		super("재고는 양의 정수여야 합니다. " + quantity);
	}
}

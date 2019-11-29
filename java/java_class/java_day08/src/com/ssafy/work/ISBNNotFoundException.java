package com.ssafy.work;

public class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException(String isbn) {
		super("입력하신 " + isbn + "에 해당하는 ISBN이 존재하지 않습니다.");
	}
}

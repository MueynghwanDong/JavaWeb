package com.ssafy.call;

public class LoginTest {
	// String id, String pass를 받아서 id가 hong, pass가 1234면 성공, 그렇지 않으면
	// 실패를 메시지와 함께 리턴하시오.
	public LoginResult login(String id, String pass) {
		if(id.equals("hong") && pass.equals("1234")) {
			return new LoginResult(true, "반갑습니다.");
		} else {
			return new LoginResult(false, "아이디 또는 비밀번호를 확인하세요");
		}
	}
	
	public static void main(String[] args) {
		LoginTest lt = new LoginTest();
		LoginResult lr = lt.login("hone", "1234");
		System.out.println(lr.getMessage() + " : " + lr.isResult());
	}
}

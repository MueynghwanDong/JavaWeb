package com.ssafy.call;

public class LoginResult {
	private boolean result;
	private String message;
	
	public LoginResult() {}

	public LoginResult(boolean result, String message) {
		this.result = result;
		this.message = message;
	}


	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

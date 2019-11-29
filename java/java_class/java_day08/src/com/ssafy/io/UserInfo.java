package com.ssafy.io;

import java.io.Serializable;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String info = "중요한 사람";

	
	@Override
	public String toString() {
		return "UserInfo [info=" + info + "]";
	}
}

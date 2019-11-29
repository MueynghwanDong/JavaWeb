package com.ssafy.pms;

public class UserInfo {

	private String id;
	private String pw;
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getpw() {
		return pw;
	}
	public void setpw(String pw) {
		this.pw = pw;
	}
	public UserInfo() {
		super();
	}
	public UserInfo(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + "]";
	}
	
		
}

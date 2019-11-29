package com.ssafy.day11.sax;

// JavaBeans: private member variable, setter & getter, default constructor
public class Info {
	private String ssn;
	private String name;
	private String email;
	private String phone;
	private String addr;
	
	
	public Info() {}
	public Info(String ssn, String name, String email, String phone, String addr) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	@Override
	public String toString() {
		return "Info [ssn=" + ssn + ", name=" + name + ", email=" + email + ", phone=" + phone + ", addr=" + addr + "]";
	}
	
}

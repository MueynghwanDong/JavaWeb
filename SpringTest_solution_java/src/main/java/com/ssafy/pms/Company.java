package com.ssafy.pms;

public class Company {
	private String vcode;
	private String vendor;

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Company(String vcode, String vendor) {
		super();
		this.vcode = vcode;
		this.vendor = vendor;
	}

	public Company() {
		super();
	}

	@Override
	public String toString() {
		return "Company [vcode=" + vcode + ", vendor=" + vendor + "]";
	}

}

package com.ssafy.day11.sax;

import java.util.Date;

public class Check {
	private Integer code;
	private Date date;
	private String clean;
	private String ready;
	private String response;
	private String request;

	public Check() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClean() {
		return clean;
	}

	public void setClean(String clean) {
		this.clean = clean;
	}

	public String getReady() {
		return ready;
	}

	public void setReady(String ready) {
		this.ready = ready;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "Check [code=" + code + ", date=" + date + ", clean=" + clean + ", ready=" + ready + ", response="
				+ response + ", request=" + request + "]";
	}

}

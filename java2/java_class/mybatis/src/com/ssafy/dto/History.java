package com.ssafy.dto;

import java.sql.Date;

public class History {
	private Integer historyNo;
	private String userId;
	private String type;
	private Integer balance;
	private Date eventTime;

	public History() {
	}

	public History(int historyNo, String userId, String type, Integer balance, Date eventTime) {
		this.historyNo = historyNo;
		this.userId = userId;
		this.type = type;
		this.balance = balance;
		this.eventTime = eventTime;
	}

	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalacne(Integer balance) {
		this.balance = balance;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "History [historyNo=" + historyNo + ", userId=" + userId + ", type=" + type + ", balance=" + balance
				+ ", eventTime=" + eventTime + "]";
	}

}

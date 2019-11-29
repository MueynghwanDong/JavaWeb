package adjava.day4.dto;

import java.sql.Date;

public class History {
	private int historyNo;
	private String userId;
	private String type;
	private Integer balacne;
	private Date eventTime;

	public History() {
	}

	public History(String userId, String type, Integer balacne) {
		this.userId = userId;
		this.type = type;
		this.balacne = balacne;
	}

	public History(int historyNo, String userId, String type, Integer balacne, Date eventTime) {
		this.historyNo = historyNo;
		this.userId = userId;
		this.type = type;
		this.balacne = balacne;
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

	public Integer getBalacne() {
		return balacne;
	}

	public void setBalacne(Integer balacne) {
		this.balacne = balacne;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "History [historyNo=" + historyNo + ", userId=" + userId + ", type=" + type + ", balacne=" + balacne
				+ ", eventTime=" + eventTime + "]";
	}

}
package com.ssafy.safefood.dto;

import java.sql.Date;

public class Qna {
	private int qnaid;
	private String title;
	private String content;
	private String qwriter;
	private Date qregdate;
	private String awriter;
	private Date aregdate;
	public Qna(int qnaid, String title, String content, String qwriter, Date qregdate, String awriter,
			Date aregdate) {
		super();
		this.qnaid = qnaid;
		this.title = title;
		this.content = content;
		this.qwriter = qwriter;
		this.qregdate = qregdate;
		this.awriter = awriter;
		this.aregdate = aregdate;
	}
	public Qna() {
		super();
	}
	public int getQnaid() {
		return qnaid;
	}
	public void setQnaid(int qnaid) {
		this.qnaid = qnaid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQwriter() {
		return qwriter;
	}
	public void setQwriter(String qwriter) {
		this.qwriter = qwriter;
	}
	public Date getQregdate() {
		return qregdate;
	}
	public void setQregdate(Date qregdate) {
		this.qregdate = qregdate;
	}
	public String getAwriter() {
		return awriter;
	}
	public void setAwriter(String awriter) {
		this.awriter = awriter;
	}
	public Date getAregdate() {
		return aregdate;
	}
	public void setAregdate(Date aregdate) {
		this.aregdate = aregdate;
	}
	
	
		
}

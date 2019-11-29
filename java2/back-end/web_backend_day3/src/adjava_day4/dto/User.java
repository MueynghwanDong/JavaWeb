package adjava_day4.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String userid;
	private String name;
	private String pass;
	private Integer balance;
	private List<History> history = new ArrayList<>();

	public User(String userid, String name, String pass, Integer balance, List<History> history) {
		this.userid = userid;
		this.name = name;
		this.pass = pass;
		this.balance = balance;
		this.history = history;
	}
	public User(String userid, String name, String pass, Integer balance) {
		this.userid = userid;
		this.name = name;
		this.pass = pass;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", pas=" + pass + ", balance=" + balance + ", history="
				+ history + "]";
	}
	public User() {

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

//	
}

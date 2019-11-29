package adjava.day4.dto;

import java.util.ArrayList;
import java.util.List;

// java beans 규약에 맞춰 User와 History를 작성하세요.
public class User {
	private String userid;
	private String name;
	private String pass;
	private int balance;

	private List<History> history = new ArrayList<>();

	public User() {
	}

	public User(String userid, String name, String pass, int balance) {
		super();
		this.userid = userid;
		this.name = name;
		this.pass = pass;
		this.balance = balance;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", pass=" + pass + ", balance=" + balance + ", history="
				+ history + "]";
	}

}

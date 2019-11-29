package adjava_day4.dto;
import java.sql.Date;

public class History {

	private Integer history_num;
	private String userid;
	private String type;
	private Integer balance;
	private Date event_time;

	
	@Override
	public String toString() {
		return "History [history_num=" + history_num + ", userid=" + userid + ", type=" + type + ", balance=" + balance
				+ ", event_time=" + event_time + "]";
	}
	public History(String userid, String type, Integer balance) {
		this(0,userid,type,balance,null);
	}
	public History() {
		super();
	}

	public History(Integer history_num, String userid, String type, Integer balance, Date event_time) {
		super();
		this.history_num = history_num;
		this.userid = userid;
		this.type = type;
		this.balance = balance;
		this.event_time = event_time;
	}

	public Integer getHistory_num() {
		return history_num;
	}

	public void setHistory_num(Integer history_num) {
		this.history_num = history_num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Date getEvent_time() {
		return event_time;
	}

	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}

}

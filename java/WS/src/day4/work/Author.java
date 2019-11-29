package day4.work;

public class Author {
	private Integer authorNo;
	private String name;
	private String phone;
	
	public Author() {}
	public Author(Integer authorNo, String name, String phone) {
		super();
		this.authorNo = authorNo;
		this.name = name;
		this.phone = phone;
	}
	public Integer getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(Integer authorNo) {
		this.authorNo = authorNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Author [authorNo=" + authorNo + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}

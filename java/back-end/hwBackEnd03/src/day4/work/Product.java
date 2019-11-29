package day4.work;

public class Product {
	private String no;
	private String name;
	private Integer price;
	private String description;
	public Product(String no, String name, Integer price, String description) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	@Override
	public String toString() {
		return no + "," +name + "," + price + "," + description;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}

package hw.dto;

public class Product {
	private String number, name, info;
	private int price;

	public Product(String number, String name, int price, String info) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.info = info;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + ", info=" + info + "]";
	}
}

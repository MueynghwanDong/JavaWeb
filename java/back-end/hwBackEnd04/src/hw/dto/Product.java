package hw.dto;

public class Product {
	private String id, name;
	private int price;
	private String description;

	public Product() {
	}

	public Product(String id, String name, int price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
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

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
}

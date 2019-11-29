package day4.work;

public class Book {
	private String isbn;
	private String title;
	private String publisher;
	private Integer price;
	private String description;
	private Integer authorno;
	
	private Author author;
	
	public Book() {
	}

	public Book(String isbn, String title, String publisher, Integer price, String description, Integer authorno) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.authorno = authorno;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
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

	public Integer getAuthorno() {
		return authorno;
	}

	public void setAuthorno(Integer authorno) {
		this.authorno = authorno;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", publisher=" + publisher + ", price=" + price
				+ ", description=" + description + ", authorno=" + authorno + ", author=" + author + "]";
	}
	
}

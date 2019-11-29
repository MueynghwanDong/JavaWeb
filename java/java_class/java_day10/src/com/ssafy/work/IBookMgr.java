package com.ssafy.work;
import java.util.*;

public interface IBookMgr {
	public boolean addBook(Book book);
	public Collection<Book> getAllBook();
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException;
	public Collection<Book> searchByTitle(String title);
	public Collection<Book> searchAllBooks();
	public Collection<Magazine> searchAllMagazine();
	public Collection<Magazine> searchThisYearMagazine();
	public Collection<Book> searchByPublisher(String publisher);
	public Collection<Book> searchByPrice(int price);
	public int getSumPrice();
	public double getAvgPrice();
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	public void buy(String isbn, int quantity) throws ISBNNotFoundException;
	public int getTotalAmount();
	public void open();
	public void close();
	public void send();
}

package com.ssafy.work;
import java.util.*;

public interface IBookMgr {
	public abstract boolean addBook(Book book);
	public abstract Collection<Book> getAllBook();
	public abstract Book searchByIsbn(String isbn) throws ISBNNotFoundException;
	public abstract Collection<Book> searchByTitle(String title);
	public abstract Collection<Book> searchAllBooks();
	public abstract Collection<Magazine> searchAllMagazine();
	public abstract Collection<Magazine> searchThisYearMagazine();
	public abstract Collection<Book> searchByPublisher(String publisher);
	public abstract Collection<Book> searchByPrice(int price);
	public abstract int getSumPrice();
	public abstract double getAvgPrice();
	public abstract void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	public abstract void buy(String isbn, int quantity) throws ISBNNotFoundException;
	public abstract int getTotalAmount();
	public abstract void open();
	public abstract void close();
}

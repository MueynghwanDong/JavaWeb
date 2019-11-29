package com.ssafy.day7.work;

import java.util.*;

public class BookMgrImpl1 implements IBookMgr {
	private List<Book> books = new ArrayList<>();
	private static BookMgrImpl1 mg = new BookMgrImpl1();
	
	private BookMgrImpl1() {
		super();
	}
	
	public static BookMgrImpl1 getBookMgrImpl1() {
		return mg;
	}
	
	// 도서 추가 시 동일한 ISBN의 책은 추가될 수 없다.
	@Override
	public boolean addBook(Book book) {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(book.getIsbn())) {
				return false;
			}
		}
		
		books.add(book);
		return true;
	}

	@Override
	public Collection<Book> getAllBook() {
		return books;
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		
		return null;
	}

	@Override
	public Collection<Book> searchByTitle(String title) {
		List<Book> list = new ArrayList<>();
		
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) {
				list.add(books.get(i));
			}
		}
		
		return list;
	}

	@Override
	public Collection<Book> searchAllBooks() {
		List<Book> list = new ArrayList<>();
		
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i) instanceof Book) {
				list.add(books.get(i));
			}
		}
		
		return list;
	}

	@Override
	public Collection<Magazine> searchAllMagazine() {
		List<Magazine> list = new ArrayList<>();
		
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i) instanceof Magazine) {
				list.add( (Magazine) books.get(i));
			}
		}
		
		return list;
	}

	@Override
	public Collection<Magazine> searchThisYearMagazine() {
		List<Magazine> list = new ArrayList<>();
		
		for(Book b : books) {
			if(b instanceof Magazine) {
				Magazine m = (Magazine) b;
				
				if(m.getYear() == 2019) {
					list.add(m);
				}
			}
		}
		
		return list;
	}

	@Override
	public Collection<Book> searchByPublisher(String publisher) {
		List<Book> list = new ArrayList<>();
		
		for(Book b : books) {
			if(b.getPublisher().contains(publisher)) {
				list.add(b);
			}
		}
		
		return list;
	}

	@Override
	public Collection<Book> searchByPrice(int price) {
		List<Book> list = new ArrayList<>();
		
		for(Book b : books) {
			if(b.getPrice() < price) {
				list.add(b);
			}
		}
		
		return list;
	}

	@Override
	public int getSumPrice() {
		int sum = 0;
		
		for(Book b : books) {
			sum += b.getPrice();
		}
		
		return sum;
	}

	@Override
	public double getAvgPrice() {
		return 1.0 * getSumPrice()/books.size();
	}

}

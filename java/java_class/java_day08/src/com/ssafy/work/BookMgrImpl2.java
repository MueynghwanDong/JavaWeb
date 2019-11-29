package com.ssafy.work;

import java.util.*;

public class BookMgrImpl2 implements IBookMgr {
	private Map<String, Book> map = new HashMap<>();
	
	// Singleton
	private static BookMgrImpl2 impl = new BookMgrImpl2();
	public static BookMgrImpl2 getBm() {
		return impl;
	}
	
	private BookMgrImpl2() {
		super();
	}
	
	@Override
	public boolean addBook(Book book) {
		if(map.containsKey(book.getIsbn())) {
			return false;
		}
		
		map.put(book.getIsbn(), book);
		return true;
	}

	@Override
	public Collection<Book> getAllBook() {
		return map.values();
	}

	@Override
	public Book searchByIsbn(String isbn) {
		return map.get(isbn);
	}

	@Override
	public Collection<Book> searchByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		for(Book book : map.values()) {
			if(book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		
		return temp;
	}

	@Override
	public Collection<Book> searchAllBooks() {
		List<Book> temp = new ArrayList<>();
		
		for(Book book : map.values()) {
			if( !(book instanceof Magazine) ) {
				temp.add(book);
			}
		}
		
		return temp;
	}

	@Override
	public Collection<Magazine> searchAllMagazine() {
		List<Magazine> temp = new ArrayList<>();
		
		for(Book book : map.values()) {
			if(book instanceof Magazine) {
				temp.add( (Magazine) book);
			}
		}
		
		return temp;
	}

	@Override
	public Collection<Magazine> searchThisYearMagazine() {
		List<Magazine> temp = new ArrayList<>();
		
		for(Book book : map.values()) {
			if(book instanceof Magazine) {
				Magazine m = (Magazine) book;
				
				if(m.getYear() == 2019) {
					temp.add(m);
				}
			}
		}
		
		return temp;
	}

	@Override
	public Collection<Book> searchByPublisher(String publisher) {
		List<Book> temp = new ArrayList<>();
		
		for(Book book : map.values()) {
			if(book.getPublisher().contains(publisher)) {
				temp.add(book);
			}
		}
		
		return temp;
	}

	@Override
	public Collection<Book> searchByPrice(int price) {
		List<Book> temp = new ArrayList<>();
		
		for(Book book : map.values()) {
			if(book.getPrice() < price) {
				temp.add(book);
			}
		}
		
		return temp;
	}

	@Override
	public int getSumPrice() {
		List<Book> temp = new ArrayList<>();

		int sum = 0;
		
		for(Book book : map.values()) {
			sum += book.getPrice();
		}
		
		return sum;
	}

	@Override
	public double getAvgPrice() {
		return 1.0 * getSumPrice() / map.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}

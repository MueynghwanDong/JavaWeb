package com.ssafy.work;

import java.util.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class BookMgrImpl1 implements IBookMgr {
	private List<Book> books = new ArrayList<>();
	private static BookMgrImpl1 mg = new BookMgrImpl1();
	private File file = new File("C:/Temp/book.dat");
	private Scanner sc = new Scanner(System.in);
	
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
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				return books.get(i);
			}
		}
		
		throw new ISBNNotFoundException(isbn);
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
			if( !(books.get(i) instanceof Magazine) ) {
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

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				if(b.getQuantity() - quantity < 0) {
					throw new QuantityException(quantity);
				} else {
					b.setQuantity(b.getQuantity() - quantity);
					return;
				}

			}
		}
		
		throw new ISBNNotFoundException(isbn);
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				b.setQuantity(b.getQuantity() + quantity);
				return;
			}
		}
		
		throw new ISBNNotFoundException(isbn);
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		
		for(Book b : books) {
			total += b.getQuantity() * b.getPrice();
		}
		
		return total;
	}

	@Override
	public void open() {
		
		try( ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file)) ) {
			Object obj = oin.readObject();
			if(obj != null && obj instanceof ArrayList) {
				books = (ArrayList) obj;
				System.out.println("데이터 목록 불러오기 성공.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			
			Book book = new Book("1", "Memorize", "Eugene", "Web Story", 55000, "Time rewind Fantasy", 6);
			books.add(book);
			Magazine magazine1 = new Magazine("4123", "Times", "Scarlet Johanson", "Java.com", 6000, "Kaka", 4,  2016, 10);
			books.add(magazine1);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void close() {
		
		try( ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file)) ) {
			oout.writeObject(books);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}

	@Override
	public void send() {
		BookClient bc = new BookClient(books, books.size());
		
		bc.start();
	}

}

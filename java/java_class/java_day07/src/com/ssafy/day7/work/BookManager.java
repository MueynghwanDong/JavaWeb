package com.ssafy.day7.work;

public class BookManager {
	Book[] books = new Book[10];
	private static BookManager bm = new BookManager();
	
	public static BookManager getBookManager() {
		return bm;
	}
	
	private BookManager() {
		
	}
	
	/**
	 * 전달받은 Book을 books에 저장. 단 배열의 요소가 null일 때
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = book;
				return true;
			}
		}
		
		return false;
	}
	
	public void showAllBooks() {
		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i]);
		}
	}
	
	public void searchIsbn(String isbn) {
		for (int i = 0; i < books.length; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				System.out.println("isbn으로 검색한 결과 : " + books[i]);
				return;
			}
		}
	}
	
	public void searchTitle(String title) {
		for (int i = 0; i < books.length; i++) {
			if(books[i].getTitle().contains(title)) {
				System.out.println("title로 검색한 결과 : " + books[i]);
			}
		}
		
	}
	
	public void searchBooks() {
		for (int i = 0; i < books.length; i++) {
			if( !(books[i] instanceof Magazine) ) {
				System.out.println(books[i]);
			}
		}
	}
	
	public void searchMagazine() {
		for (int i = 0; i < books.length; i++) {
			if(books[i] instanceof Magazine) {
				System.out.println(books[i]);
			}
		}
	}
	
	public void showThisYearMagazines() {
		for (int i = 0; i < books.length; i++) {
			if(books[i] instanceof Magazine) {
				Magazine m = (Magazine) books[i];
				
				if(m.getYear() == 2019) {
					System.out.println(m);
				}
			}
		}
	}
	
	public void searchByPublisher(String publisher) {
		for (int i = 0; i < books.length; i++) {
			if(books[i].getPublisher().contains(publisher)) {
				System.out.println(books[i]);
			}
		}
	}
	
	public void searchByPrice(int price) {
		for (int i = 0; i < books.length; i++) {
			if(books[i].getPrice() == price) {
				System.out.println(books[i]);
			}
		}
	}
	
	public void showSum() {
		int sum = 0;
		
		for (int i = 0; i < books.length; i++) {
			sum += books[i].getPrice();
		}
		
		System.out.println("총 가격의 합 : " + sum);
	}
	
	public void showAvg() {
		int sum = 0;
		
		for (int i = 0; i < books.length; i++) {
			sum += books[i].getPrice();
		}
		
		System.out.println("총 합의 평균 : " + (double)sum / books.length);
	}
}

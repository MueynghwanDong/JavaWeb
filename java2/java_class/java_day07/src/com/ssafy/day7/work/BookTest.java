package com.ssafy.day7.work;

import java.util.*;

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("21421", "Java Pro", "Kim Hana", "Jaen.kr", 15000, "Java Basic");
		Book book2 = new Book("35352", "Technology", "Tree", "Jaen.kr", 30000, "SW Modeling");
		Book book3 = new Book("3746", "Sapiens", "Harari", "Jaen.kr", 28000, "Origin of the God");
		Book book4 = new Book("2368", "Homo Deus", "Harari", "Jaen.kr", 33000, "Future of Mankind");
		Book book5 = new Book("34", "Dragon Saga", "Kim, Hyeong", "Jaen.kr", 14000, "Fantasy");
		Book book6 = new Book("8563", "Super Food", "Eat", "Jaen.kr", 30000, "Deliious");
		
		Magazine magazine1 = new Magazine("4123", "Haha", "Ho", "Java.com", 6000, "Kaka", 2016, 10);
		Magazine magazine2 = new Magazine("236", "Haha", "Ho", "Java.com", 6000, "Kaka", 2019, 6);
		Magazine magazine3 = new Magazine("2367", "Haha", "Ho", "Java.com", 6000, "Kaka", 2019, 7);
		Magazine magazine4 = new Magazine("1212", "Haha", "Ho", "Java.com", 6000, "Kaka", 2018, 11);
		Magazine magazine5 = new Magazine("879", "Haha", "Ho", "Java.com", 6000, "Kaka", 2017, 4);
		
		Book[] books = {book1, book2, book3, book4, book5, book6, magazine1, 
				magazine2, magazine3, magazine4, magazine5};
		
		BookMgrImpl1 bm = BookMgrImpl1.getBookMgrImpl1();
		BookMgrImpl2 bm2 = BookMgrImpl2.getBm();
		
		// 1. 데이터 입력 기능
		for(Book book: books) {
			bm2.addBook(book);
		}
		
		// 2. 데이터 전체 검색 기능
		Collection<Book> col = bm2.getAllBook();
		for(Book book : col) {
			System.out.println(book);
		}
		
		// 3. isbn에 해당하는 책을 조회해서 출력하자.
		Book b = bm2.searchByIsbn("34");
		System.out.printf(" ** 특정 ISBN에 해당하는 책 ** \n%s\n", b);
		
		// 4. title을 포함하는 책을 조회해서 출력하자.
		col = bm2.searchByTitle("Java");
		System.out.printf(" ** 특정 title로 검색한 결과 ** \n");
		for(Book book : col) {
			System.out.println(book);
		}
		
		
		// 5.
		col = bm2.searchAllBooks();
		System.out.println(" ** 모든 Book 리스트 **\n");
		for(Book book : col) {
			System.out.println(book);
		}
		
		// 6.
		Collection<Magazine> col2 = bm2.searchAllMagazine();
		System.out.println(" ** 모든 Magazine 리스트 **\n");
		for(Book book : col2) {
			System.out.println(book);
		}
		
		// 7.
		col2 = bm2.searchThisYearMagazine();
		System.out.println(" ** 올해 나온 Magazine 리스트 **\n");
		for(Book book : col2) {
			System.out.println(book);
		}
		
		// 8.
		col = bm2.searchByPublisher("Java.com");
		System.out.println(" ** 특정 출판사가 만든 책들 **\n");
		for(Book book : col) {
			System.out.println(book);
		}
		
		// 9.
		col = bm2.searchByPrice(30000);
		System.out.println(" ** 특정 가격 이하의 책들 **\n");
		for(Book book : col) {
			System.out.println(book);
		}
		
		// 10.
		System.out.println("** 전체 가격 **\n" + bm2.getSumPrice());
		
		// 11.
		System.out.println("** 가격 평균 **\n" + bm2.getAvgPrice());
	}
}

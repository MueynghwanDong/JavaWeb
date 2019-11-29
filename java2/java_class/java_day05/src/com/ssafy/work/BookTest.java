package com.ssafy.work;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("21421", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book book2 = new Book("35352", "분석설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
		Book book3 = new Book("3746", "사피엔스", "유발 하라리", "Jaen.kr", 28000, "신의 기원");
		Book book4 = new Book("2368", "호모데우스", "유발 하라리", "Jaen.kr", 33000, "인류의 미래");
		Book book5 = new Book("34", "드래곤라자", "김형도", "Jaen.kr", 14000, "판타지");
		Book book6 = new Book("8563", "떡볶이", "먹고싶어", "Jaen.kr", 30000, "존맛");
		
		Magazine magazine1 = new Magazine("4123", "하하하", "편집부", "Java.com", 6000, "호호호", 2016, 10);
		Magazine magazine2 = new Magazine("236", "하하하", "편집부", "Java.com", 6000, "호호호", 2019, 6);
		Magazine magazine3 = new Magazine("2367", "하하하", "편집부", "Java.com", 6000, "호호호", 2019, 7);
		Magazine magazine4 = new Magazine("1212", "하하하", "편집부", "Java.com", 6000, "호호호", 2018, 11);
		Magazine magazine5 = new Magazine("879", "하하하", "편집부", "Java.com", 6000, "호호호", 2017, 4);
		
		Book[] books = {book1, book2, book3, book4, book5, book6, magazine1, 
				magazine2, magazine3, magazine4, magazine5};
		
		BookManager bm = BookManager.getBookManager();
		
		// 1. 데이터 입력 기능
		for(Book book: books) {
			bm.addBook(book);
		}
		
		// 2. 데이터 전체 검색 기능
//		bm.showAllBooks();
		
		// 3. isbn에 해당하는 책을 조회해서 출력하자.
		bm.searchIsbn("34");
		
		// 4. title을 포함하는 책을 조회해서 출력하자.
		bm.searchTitle("사피엔");
		
		// 5.
//		bm.searchBooks();
		
		// 6.
//		bm.searchMagazine();
		
		// 7.
//		bm.showThisYearMagazines();
		
		// 8.
//		bm.searchByPublisher("편집부");
		
		// 9.
		bm.searchByPrice(30000);
		
		// 10.
		bm.showSum();
		
		// 11.
		bm.showAvg();
	}
}

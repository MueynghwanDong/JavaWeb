package com.ssafy.work;

import java.util.*;

public class BookTest {

	public static void main(String[] args) {
		BookMgrImpl1 bm = BookMgrImpl1.getBookMgrImpl1();
//		BookMgrImpl2 bm2 = BookMgrImpl2.getBm();
		
		bm.open();
		
		// 1. 데이터 입력 기능
//		for(Book book: bm.getAllBook()) {
//			bm.addBook(book);
//		}
		
		// 2. 데이터 전체 검색 기능
		System.out.println("========================================================== 전체 목록 ==========================================================");
		for(Book book : bm.getAllBook()) {
			System.out.println(book);
		}
		System.out.println("===============================================================================================================================");
		
		
		// 3. isbn에 해당하는 책을 조회해서 출력하자.

		Book b;
		try {
			b = bm.searchByIsbn("34");
			System.out.printf("\n ** 특정 ISBN에 해당하는 책 ** \n%s\n", b);
		} catch (ISBNNotFoundException e) {
			System.out.printf("\n ** 특정 ISBN에 해당하는 책 ** \n");
			System.out.println(" 특정 ISBN에 해당하는 책이 없습니다.");
		}
		
		// 4. title을 포함하는 책을 조회해서 출력하자.
		System.out.printf("\n ** 특정 title로 검색한 결과 ** \n");
		for(Book book : bm.searchByTitle("Java")) {
			System.out.println(book);
		}
		
		
		// 5. Magazine을 제외한 Book을 출력하자.
		System.out.println("\n ** 모든 Book 리스트 **\n");
		for(Book book : bm.searchAllBooks()) {
			System.out.println(book);
		}
		
		// 6. Magazine만 출력하자
		System.out.println("\n ** 모든 Magazine 리스트 **\n");
		for(Book book : bm.searchAllMagazine()) {
			System.out.println(book);
		}
		
		// 7. 올해 나온 Magazine만 출력
		System.out.println("\n ** 올해 나온 Magazine 리스트 **\n");
		for(Book book : bm.searchThisYearMagazine()) {
			System.out.println(book);
		}
		
		// 8. 특정 출판사의 책만 출력
		System.out.println("\n ** 특정 출판사가 만든 책들 **\n");
		for(Book book : bm.searchByPublisher("Java.com")) {
			System.out.println(book);
		}
		
		// 9. 특정 가격 이하의 책만 출력
		System.out.println("\n ** 특정 가격 이하의 책들 **\n");
		for(Book book : bm.searchByPrice(30000)) {
			System.out.println(book);
		}
		
		// 10. 책 전체 가격
		System.out.println("\n** 전체 가격 **\n" + bm.getSumPrice());
		
		// 11. 책들의 평균 가격
		System.out.println("\n** 가격 평균 **\n" + bm.getAvgPrice());
		
		// 12. 도서 쇼핑몰이 책을 구매
		try {
			bm.buy("4123", 10);
		} catch (ISBNNotFoundException e) {
			System.out.println("특정 ISBN에 해당하는 책이 없습니다.");
		}
		
		System.out.println("\n ** 책 ISBN 4123 10권 구매후 결과 **\n");
		System.out.println("========================================================== 전체 목록 ==========================================================");
		for(Book book : bm.getAllBook()) {
			System.out.println(book);
		}
		System.out.println("===============================================================================================================================");
		
		// 13. 도서 쇼핑몰이 책을 판매
		
		try {
			bm.sell("4123", 4);
		} catch (QuantityException e) {
			System.out.println("그만한 수량을 가지고 있지 않습니다.");
		} catch (ISBNNotFoundException e) {
			System.out.println("특정 ISBN에 해당하는 책이 없습니다.");
		}
		
		System.out.println("\n ** 책 ISBN 4123 4권 판매후 결과 **\n");
		System.out.println("========================================================== 전체 목록 ==========================================================");
		for(Book book : bm.getAllBook()) {
			System.out.println(book);
		}
		System.out.println("===============================================================================================================================");
		
		// 14. 재고 도서들의 수량 * 금액 출력
		System.out.println("\n** 전체 재고포함 가격 **\n" + bm.getTotalAmount());
		
		bm.close();
		
		// 서버로 전송
		bm.send();
	}
}

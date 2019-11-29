package com.ssafy.work;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		BookDAO dao = BookDAO.getDao();
		
//		dao.insertBook(new Book("a1101", "JAVA 기본", "자엔 기술연구소", "자엔 출판사", 23000, "기본", 1));
//		dao.insertBook(new Book("a1102", "JAVA 중급", "자엔 기술연구소", "자엔 출판사", 25000, "중급", 1));
//		dao.insertBook(new Book("a1103", "JAVA 실전", "자엔 기술연구소", "자엔 출판사", 30000, "실전", 1));
		
//		dao.insertBook(new Book("a1104", "JAVA 심화", "자엔 기술연구소", "자엔 출판사", 28000, "심화", 1));
//		dao.updateBook(new Book("a1101", "JAVA 기본", "자엔 기술연구소", "자엔 출판사", 20000, "기본", 1));
		
		System.out.println("---------------------------a1101 도서 검색--------------------------+-\n" + dao.findBook("a1101"));
		
//		dao.deleteBook(new Book("a1103", "JAVA 실전", "자엔 기술연구소", "자엔 출판사", 30000, "실전", 1));
		
		printAllBooks(dao.listBooks());
		System.out.println("총 책의 개수 : " +dao.count());
	}
	
	private static void printAllBooks(List<Book> list) {
		System.out.println("--------+-----------------------------+-----------------------------+-");
		for(Book book : list) {
			System.out.println(book);
		}
		System.out.println("--------+-----------------------------+-----------------------------+-");
	}
}

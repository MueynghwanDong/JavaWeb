package day4.work;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		BookAuthorDao bad = BookAuthorDaoImpl.getImpl();
		System.out.println("3번");
		System.out.println(bad.getTitlePriceAuthorUsingBookAuthor());
		
		System.out.println("4번");
		System.out.println(bad.getTitleIsbnPublisherByAuthorName());
		
		System.out.println("5번");
		System.out.println(bad.getTitlePublisherPriceAuthroNamePerAuthor());
		
		System.out.println("6번");
		bad.printInfo();
		
	}
	
}

package day4.work;

import java.util.List;
import java.util.Map;

public interface BookAuthorDao {
	//3 Book과Author 테이블을JOIN하여도서명, 가격, 저자명을검색하세요.
	List<Map<String, Object>> getTitlePriceAuthorUsingBookAuthor();
	
	//4 이름이‘김태희’인 저자의 도서명, isbn, 출판사를 출력하세요.
	List<Map<String, String>> getTitleIsbnPublisherByAuthorName();
	
	//5 author 저자명과 출간된 도서들을 도서명, 출판사, 가격을 출력하라
	List<Map<String, Object>> getTitlePublisherPriceAuthroNamePerAuthor();
	
	//6 Book 테이블에있는title와publisher를이용하여서로의관계를다음과같이출력되도록쿼리를작성하세요. ( ‘IoT세상은미래닷컴에서출판했다’)
	void printInfo();
}

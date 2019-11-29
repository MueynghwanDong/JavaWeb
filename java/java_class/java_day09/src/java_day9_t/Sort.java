package java_day9_t;

import java.util.*;

public class Sort {
	
	static class Product implements Comparable<Product>{
		String serial;
		int price;
		
		public Product(String serial, int price) {
			super();
			this.serial = serial;
			this.price = price;
		}

		
		@Override
		public String toString() {
			return "Product [serial=" + serial + ", price=" + price + "]";
		}


		@Override
		public int compareTo(Product o) {
			// 기본형 보다는 객체의 compareTo를 사용하자
			return Integer.valueOf(this.price).compareTo(o.price);
		}
	}
	
	
	public static void main(String[] args) {
		// 정렬은 순서가 필요 ==> List, 배열이 정렬의 대상 !
		
		// Comparable : 어떤 객체가 Comparable을 구현하고 있으면 언제나 정렬이 가능하다. 하지만 기본 정렬, 고정, 자주 사용되는 정렬.
		// 			예) String, Number
		List<String> list = Arrays.asList("Hello", "Java", "World", "Nice");
		Collections.sort(list);
		System.out.println(list); 	// Comparable에 의한 기본 정렬 적용
		
		List<Product> list2 = Arrays.asList(new Product("123", 123), new Product("789", 789), new Product("456", 456));
		Collections.sort(list2);
		
		System.out.println(list2);
		
		
		
		// Comparator : 정렬이 불가능한 어떤 객체를 정렬 해주는 녀석, 동적으로 정렬 기준 제시 가능, 만능.
		Collections.sort(list2, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
//				return o1.serial.compareTo(o2.serial);		// serial 번호 오름차순
//				return o2.serial.compareTo(o1.serial);		// serial 번호 내림차순
//				return o1.serial.compareTo(o2.serial) * -1;	// serial 번호 내림차순
				return Integer.valueOf(o1.price).compareTo(o2.price) * -1;	// 가격 내림차순
			}
			
		});
		
		// set은 정렬할 수 없다. 중복 허용 x 	 BUT ! TreeSet은 Comparable하다면 그 기준으로 정렬해줌
		Set<String> set = new HashSet<>(list);
		
		// 그래서 정렬하려면 list로 바꿔서 해야한다.
		List<String> reList = new ArrayList<>(set);
		
		// map 정렬? map도 순서가 없기 때문에 기본적으로 정렬 불가. 
		Map<String, Product> map = new HashMap<>();
		map.put("123", new Product("123", 123));
		map.put("789", new Product("789", 789));
		map.put("456", new Product("456", 456));
		
		// 하지만 TreeMap이 있다. (키 값을 기준으로) 정렬이 가능한 맵이다.
		List<Product> values = new ArrayList<>(map.values());
		
		Collections.sort(values, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(values);
		
		Collections.sort(values, (o1, o2) -> o1.compareTo(o2));
		
		
	}
}





















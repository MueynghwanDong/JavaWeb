package com.ssafy.day7.collection.sort;
import java.util.*;

import com.ssafy.day7.collection.set.HandPhone;

public class TreeSetTest {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		set.add("Red");
		set.add("Blue");
		set.add("Yellow");
		set.add("Green");
		set.add("Black");
		System.out.println(set);

		Set<HandPhone> set2 = new TreeSet<>();		// TreeSet은 데이터가 들어올 때마다 데이터를 정렬함. 하지만 HandPhone 객체는
		// 대소비교가 불가능하기 때문에 add할 수 없다.
		set2.add(new HandPhone("010", 100));
		set2.add(new HandPhone("011", 130));
		set2.add(new HandPhone("019", 140));
		set2.add(new HandPhone("017", 90));
		System.out.println(set2);

		List<HandPhone> list = new ArrayList<>();
		list.addAll(set2);	// set2의 모든 정보가 list에 담긴다.

		HandPhoneComparator hc = new HandPhoneComparator();
		Collections.sort(list, hc);
		
		System.out.println(list);

		Collections.sort(list, new Comparator<HandPhone>() {	// 익명 이너 클래스를 사용해 정렬.

			@Override
			public int compare(HandPhone o1, HandPhone o2) {
				return o1.number.compareTo(o2.number);
			}
		});

		List<String> strList = Arrays.asList("Dream", "is", "come", "true");

		// 내림차순으로 정렬해보자.
		Collections.sort(strList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2) * -1;
			}
		});

		System.out.println(strList);

		// 글자 수를 기준으로 정렬해보자.
		Collections.sort(strList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 글자수가 같을 때는 알파벳 오름차순으로 정렬
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
				}
			}
		});

		System.out.println(strList);
	}
}













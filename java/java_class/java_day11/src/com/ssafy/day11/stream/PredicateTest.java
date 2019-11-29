package com.ssafy.day11.stream;

import java.util.ArrayList;
import java.util.List;

public class PredicateTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("java");
		list.add("World");
		list.add("Dream is ..");
		list.removeIf(str -> str.length() >= 5);
		
		System.out.println(list);
	}
}

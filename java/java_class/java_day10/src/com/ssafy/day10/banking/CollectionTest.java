package com.ssafy.day10.banking;

import java.util.*;

public class CollectionTest {
	
	public static void main(String[] args) {
		testList(new Vector<>());
		testList(new ArrayList<>());
		
		
	}
	
	public static void testList(List<Integer> list) {
		long start = System.currentTimeMillis();
		
		for(int i=0; i < 5000000; i++) {
			list.add(i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(list.getClass().getName() + " : " + (end-start));
	}
}

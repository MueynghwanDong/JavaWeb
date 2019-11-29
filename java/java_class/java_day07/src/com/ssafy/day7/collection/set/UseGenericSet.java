package com.ssafy.day7.collection.set;
import java.util.*;

public class UseGenericSet {
	static Set<String> set = new HashSet<>();
	static List<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		set.add("Make way for Prince Ali");
		set.add("Say hey. It's Prince Ali");
		set.add("Old bazzar. It's the brand new star.");
		set.add("You'll gonna love this guy ! ");
	
		int len = 0;
		
		for(String str : set) {
			len += str.length();
		}
		
		System.out.println(len);
	}
}

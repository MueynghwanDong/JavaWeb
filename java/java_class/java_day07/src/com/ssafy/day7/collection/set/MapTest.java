package com.ssafy.day7.collection.set;

import java.util.*;

public class MapTest {
	Map <String, String> map = new HashMap<>();
	
	// CRUD
	public void addTest() {
		map.put("name", "Peter Parker");
		map.put("addr", "New York");
		map.put("name", "Tony Stark");
		map.put("본적지", "서울");
		System.out.println(map);
	}
	public void getTest() {
		System.out.println(map.get("크기 : " + map.size()));
		System.out.println(map.containsKey("name") + " : " + map.containsValue("서울"));
		// 데이터 조회
		System.out.println(map.keySet()); 	// 키 목록
		System.out.println(map.values());	// 값 목록
		
		String value = map.get("name");
		System.out.println(value);
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	public void updateTest() {
		map.put("name", "장길산");
		
		System.out.println(map);
	}
	public void deleteTest() {
		map.remove("name");
		map.clear();
		
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		MapTest mp = new MapTest();
		mp.addTest();
		mp.getTest();
		mp.updateTest();
		mp.deleteTest();
	}
}

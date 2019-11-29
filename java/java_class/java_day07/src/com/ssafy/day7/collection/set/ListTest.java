package com.ssafy.day7.collection.set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
//	List<String> list = new ArrayList<String>(5);		// 규모가 예측이 가능하다면 초기 값을 주는 것이 더욱 효율적으로 동작한다.
							// ArrayList는 순차적으로 접근하는 부분에서는 강력하지만 비 순차적으로 접근하거나 삭제, 갱신하는 작업엔
							// 비효율적이다. 그래서 나온 것이 LinkedList.
	
	List<String> list = new LinkedList<String>();
	
	// CRUD
	public void addTest() {
		// list에 데이터를 넣고 출력해보세요.
		
		list.add("And the wind from the east and the sun from the west");
		list.add("Another arabian night");
		list.add("A hundred bad guys with sword.");
		list.add(0, "I can show you the world.");
		list.add("A whole new world.");
		
		System.out.println(list);
	}
	public void getTest() {
		System.out.println("크기 : " + list.size());
		System.out.println("포함 ? " + list.contains("A whole new world."));
		System.out.println(list.get(0));
		
		for(String str : list) {
			System.out.println(str);
		}
	}
	public void updateTest() {
		list.set(0, "replace");
		System.out.println("변경 후 : " + list);
	}
	public void deleteTest() {
		list.remove("A whole new world.");
		list.remove(0);
		
		System.out.println("삭제 후 : " + list);
		list.clear();
		System.out.println("초기화 후 : " + list);
	}
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		
		lt.addTest();
		lt.getTest();
		lt.updateTest();
		lt.deleteTest();
	}
}

package com.ssafy.modifier;

public class TeacherTest {
	
	public static void main(String[] args) {
		SingletonTeacher st = SingletonTeacher.getTeacher();
		st.teach();
		
		SingletonTeacher st2 = SingletonTeacher.getTeacher();
		st.teach();
		
		System.out.println(st == st2);
	}
}

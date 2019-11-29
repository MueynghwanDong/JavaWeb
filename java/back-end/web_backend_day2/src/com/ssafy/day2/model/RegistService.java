package com.ssafy.day2.model;

import java.util.Arrays;

public class RegistService {
	public boolean regist(String name, String id, String pass, String[] alergy) {
		System.out.println(name + " : " + id + " : " + pass + " : " + Arrays.toString(alergy));
		return !id.equals("admin");
	}
}

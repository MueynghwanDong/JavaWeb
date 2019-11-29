package com.ssafy.day7.collection.sort;

import java.util.Comparator;

import com.ssafy.day7.collection.set.HandPhone;

public class HandPhoneComparator implements Comparator<HandPhone>{

	@Override
	public int compare(HandPhone o1, HandPhone o2) {
		return o1.number.compareTo(o2.number);
	}
}

// 정렬 !, Command Line Menu !!
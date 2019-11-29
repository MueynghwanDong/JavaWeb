package com.ssafy.day7.collection.set;

public class GenericPocket<T> {	// T: 어떤 하나의 타입을 의미한다.
	T some;

	
	
	public T getSome() {
		return some;
	}
	public void setSome(T some) {
		this.some = some;
	}
}
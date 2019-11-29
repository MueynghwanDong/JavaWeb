package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.Eat;

public interface EatService {

	public List<Eat> select(String id);
	public int insert(Eat eat);
	public int delete(int idx);
}

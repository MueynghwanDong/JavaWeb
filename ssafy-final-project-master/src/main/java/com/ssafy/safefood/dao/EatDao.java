package com.ssafy.safefood.dao;

import java.util.List;

import com.ssafy.safefood.dto.Eat;

public interface EatDao {

	public List<Eat> select(String id);
	public int insert(Eat eat);
	public int delete(int idx);
}

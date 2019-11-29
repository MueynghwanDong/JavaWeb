package com.ssafy.safefood.dao;

import java.util.List;

import com.ssafy.safefood.dto.Jjim;

public interface JjimDao {
	public List<Jjim> select(String id);
	public int insert(Jjim jjim);
	public int delete(int idx);
}

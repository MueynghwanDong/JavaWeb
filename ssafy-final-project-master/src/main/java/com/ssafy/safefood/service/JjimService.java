package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.Jjim;

public interface JjimService {
	public List<Jjim> select(String id);
	public int insert(Jjim jjim);
	public int delete(int idx);
}

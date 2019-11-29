package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.EatDao;
import com.ssafy.safefood.dto.Eat;

@Service
public class EatServiceImpl implements EatService {

	@Autowired
	EatDao edao;

	@Override
	public List<Eat> select(String id) {
		return edao.select(id);
	}

	@Override
	public int insert(Eat eat) {
		return edao.insert(eat);
	}

	@Override
	public int delete(int idx) {
		return edao.delete(idx);
	}

}

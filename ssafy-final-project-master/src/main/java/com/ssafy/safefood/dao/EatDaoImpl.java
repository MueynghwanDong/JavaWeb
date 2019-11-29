package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Eat;

@Repository
public class EatDaoImpl implements EatDao{

	@Autowired
	SqlSession session;
	
	private static String ns = "com.ssafy.mapper.EatMapper.";
	
	@Override
	public List<Eat> select(String id) {
		return session.selectList(ns+"select",id);
	}

	@Override
	public int insert(Eat eat) {
		return session.insert(ns+"insert", eat);
	}

	@Override
	public int delete(int idx) {
		return session.delete(ns+"delete",idx);
	}

}

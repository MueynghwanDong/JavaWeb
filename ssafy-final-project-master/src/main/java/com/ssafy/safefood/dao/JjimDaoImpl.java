package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Jjim;

@Repository
public class JjimDaoImpl implements JjimDao {

	private static String ns = "com.ssafy.mapper.JjimMapper.";

	@Autowired
	SqlSession session;
	
	@Override
	public List<Jjim> select(String id) {
		return session.selectList(ns+"select",id);
	}

	@Override
	public int insert(Jjim jjim) {
		return session.insert(ns+"insert",jjim);
	}

	@Override
	public int delete(int idx) {
		return session.delete(ns+"delete",idx);
	}

}

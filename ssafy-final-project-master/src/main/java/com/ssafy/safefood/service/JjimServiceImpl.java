package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.JjimDao;
import com.ssafy.safefood.dto.Jjim;

@Service
public class JjimServiceImpl implements JjimService {

	@Autowired
	JjimDao jdao;
	
	@Override
	public List<Jjim> select(String id) {
		return jdao.select(id);
	}

	@Override
	public int insert(Jjim jjim) {
		return jdao.insert(jjim);
	}

	@Override
	public int delete(int idx) {
		return jdao.delete(idx);
	}

}

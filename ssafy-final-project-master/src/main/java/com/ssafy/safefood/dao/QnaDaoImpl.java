package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Qna;

@Repository
public class QnaDaoImpl implements QnaDao {

	@Autowired
	SqlSession session;

	private static String ns = "com.ssafy.mapper.QnaMapper.";

	@Override
	public int regitser(Qna qna) throws Exception {
		return session.insert(ns + "insert", qna);
	}

	@Override
	public int update(Qna qna) throws Exception {
		return session.update(ns + "update", qna);
	}

	@Override
	public int delete(Integer qnaid) throws Exception {
		return session.delete(ns + "delete", qnaid);
	}

	@Override
	public Qna selectone(Integer qnaid) throws Exception {
		return session.selectOne(ns + "selectone", qnaid);
	}

	@Override
	public List<Qna> qselect() throws Exception {
		return session.selectList(ns + "select");

	}

	@Override
	public int aupdate(Qna qna) throws Exception {
		return session.update(ns + "aupdate", qna);
	}

	@Override
	public int adelete(Qna qna) throws Exception {
		return session.update(ns+"adelete",qna);
	}

	@Override
	public List<Qna> search(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(ns+"search",keyword);

	}

	@Override
	public List<Qna> searchWriter(String writer) throws Exception {
		return session.selectList(ns+"searchwriter",writer);
	}

}

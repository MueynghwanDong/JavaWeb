package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Board;
import com.ssafy.safefood.dto.Criteria;
import com.ssafy.safefood.dto.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDao {

	@Autowired
	SqlSession session;
	
	private static String ns = "com.ssafy.mapper.BoardMapper.";

	@Override
	public int create(Board vo) throws Exception {
		return session.insert(ns + "create", vo);

	}

	@Override
	public Board read(Integer bno) throws Exception {
		return session.selectOne(ns + "read", bno);
	}

	@Override
	public int update(Board vo) throws Exception {
		return session.update(ns + "update", vo);

	}

	@Override
	public int delete(Integer bno) throws Exception {
		return session.delete(ns + "delete", bno);

	}

	@Override
	public List<Board> listAll() throws Exception {
		return session.selectList(ns + "listAll");
	}

	@Override
	public List<Board> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(ns + "listPage", page);
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return session.selectList(ns + "listCriterial", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(ns + "countPaging", cri);
	}

	@Override
	public List<Board> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(ns + "listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(ns + "listSearchCount", cri);
	}


	@Override
	public int updateViewCnt(Integer bno) throws Exception {
		return session.update(ns + "updateViewCnt", bno);

	}

	@Override
	public int bupdate(Board vo) throws Exception {
		return session.update(ns + "bupdate", vo);
	}


}
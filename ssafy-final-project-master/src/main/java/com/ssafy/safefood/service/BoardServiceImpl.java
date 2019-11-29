package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.BoardDao;
import com.ssafy.safefood.dto.Board;
import com.ssafy.safefood.dto.Criteria;
import com.ssafy.safefood.dto.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;

	@Override
	public int regist(Board vo) throws Exception {
		return dao.create(vo);

	}

	@Override
	public Board read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public int modify(Board vo) throws Exception {
		return dao.update(vo);

	}

	@Override
	public int remove(Integer bno) throws Exception {
		return dao.delete(bno);

	}

	@Override
	public List<Board> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public List<Board> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public int updateViewCnt(Integer bno) throws Exception {
		return dao.updateViewCnt(bno);

	}

	@Override
	public int bmodify(Board vo) throws Exception {
		return dao.bupdate(vo);
	}
	
	
}

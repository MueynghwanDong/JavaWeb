package com.ssafy.safefood.dao;

import java.util.List;

import com.ssafy.safefood.dto.Board;
import com.ssafy.safefood.dto.Criteria;
import com.ssafy.safefood.dto.SearchCriteria;

public interface BoardDao {
	public int create(Board vo) throws Exception;

	public Board read(Integer bno) throws Exception;

	public int update(Board vo) throws Exception;
	public int bupdate(Board vo) throws Exception;

	public int delete(Integer bno) throws Exception;

	public List<Board> listAll() throws Exception;

	public List<Board> listPage(int page) throws Exception;

	public List<Board> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<Board> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;


	public int updateViewCnt(Integer bno) throws Exception;

}
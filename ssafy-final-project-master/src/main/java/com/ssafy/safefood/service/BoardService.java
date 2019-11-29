package com.ssafy.safefood.service;

import java.util.List;

import com.ssafy.safefood.dto.Board;
import com.ssafy.safefood.dto.Criteria;
import com.ssafy.safefood.dto.SearchCriteria;

public interface BoardService {

	public int regist(Board vo) throws Exception;

	public Board read(Integer bno) throws Exception;

	public int modify(Board vo) throws Exception;

	public int bmodify(Board vo) throws Exception;

	public int remove(Integer bno) throws Exception;

	public List<Board> listAll() throws Exception;

	public List<Board> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<Board> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public int updateViewCnt(Integer bno) throws Exception;

	
}	
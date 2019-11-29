package com.ssafy.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public interface BoardDao {
	public int getBoardNo(SqlSession session) ;

	public int insertBoard(SqlSession session, Board board) ;

	public Board search(SqlSession session, String no) ;

	public Map<String, Object> searchAll(SqlSession session, PageBean bean) ;

	//public int count(SqlSession session, PageBean bean) ;

	public int updateBoard(SqlSession session, Board board) ;

	public int deleteBoard(SqlSession session, String no) ;
}

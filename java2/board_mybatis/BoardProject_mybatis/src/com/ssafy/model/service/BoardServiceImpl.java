package com.ssafy.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.MyBatisUtil;

public class BoardServiceImpl implements BoardService {
	
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	BoardDao dao = BoardDaoImpl.getImpl();

	public BoardServiceImpl() {
	}

	public BoardServiceImpl(BoardDao dao) {
		super();
		this.dao = dao;
	}

	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void insertBoard(Board board) {
		SqlSession session=null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			int no = dao.getBoardNo(session);
			board.setNo(no);
			dao.insertBoard(session, board);
			session.commit();
		} catch (RuntimeException e) {
			logger.error("insert fail", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateBoard(Board board) {
		SqlSession session=null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			dao.updateBoard(session, board);
			session.commit();
		} catch (RuntimeException e) {
			logger.error("update fail", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteBoard(String no) {
		SqlSession session=null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			dao.deleteBoard(session, no);
			session.commit();
		} catch (RuntimeException e) {
			logger.error("d fail", e);
		} finally {
			session.close();
		}
	}

	@Override
	public Board search(String no) {
		SqlSession session=null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			return dao.search(session, no);
		} catch (RuntimeException e) {
			logger.error("d fail", e);
			throw new BoardException("게시물 검색 중 오류 발생");
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> searchAll(PageBean bean) {
		SqlSession session=null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			return dao.searchAll(session, bean);
		} catch (RuntimeException e) {
			logger.error("d fail", e);
			throw new BoardException("게시물 검색 중 오류 발생");
		} finally {
			session.close();
		}
	}
}

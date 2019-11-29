package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.MyBatisUtil;

public class BoardDaoTest {
	
	private static Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	BoardDao dao;
	SqlSession session;
	@Before
	public void setup() {
		dao = BoardDaoImpl.getImpl();
		session = MyBatisUtil.getUtil().getSession();
	}
	
	@After
	public void clear() {
		session.rollback();
	}
	
	@Test
	public void getMaxTest() {
		int max = dao.getBoardNo(session);
		assertThat(max, is(10));
	}
	
	@Test
	public void insertTest() {
		Board board = new Board("hong", "test", "test");
		int result = dao.insertBoard(session, board);
		assertThat(result, is(1));
	}
	
	@Test
	public void selectTest() {
		Board board = dao.search(session, "1");
		assertThat(board.getId(), is("ssafy"));
		assertThat(board.getContents(), is("처음하는 게시판"));
	}
	@Test
	public void selectAllTest() {
		int pageNo = 0;
		PageBean bean = new PageBean("id", "ssafy", pageNo*5+"");
		Map<String, Object> map = dao.searchAll(session, bean);
		
		assertThat(map.get("totalNumber"), is(8));
		
	}
	
	@Test
	public void updateTest() {
		Board board = dao.search(session, "1");
		logger.trace("board: {}", board);
		board.setContents("수정 될까요?");
		dao.updateBoard(session, board);
		
		Board selected = dao.search(session, "1");
		assertThat(board, is(selected));
	}
	
	@Test
	public void deleteTest() {
		Board board = dao.search(session, "1");
		logger.trace("board: {}", board);
		dao.deleteBoard(session, String.valueOf(board.getNo()));
		
		Board selected = dao.search(session, "1");
		assertThat(selected, is(nullValue()));
	}
}

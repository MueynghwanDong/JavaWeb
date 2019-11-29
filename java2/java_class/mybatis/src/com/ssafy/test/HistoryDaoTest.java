package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ssafy.dao.HistoryDao;
import com.ssafy.dto.History;
import com.ssafy.util.MyBatisUtil;

public class HistoryDaoTest {

	HistoryDao dao;
	SqlSession session;

	
	@Before
	public void setUp() throws Exception {
		dao = HistoryDao.getDao();
		session = MyBatisUtil.getUtil().getSession();
	}

	@After
	public void tearDown() throws Exception {
		session.rollback();
	}


	@Test
	public void testSelectByMap() {
		Map<String, Object> result = dao.selectByMap(session, 11);
		assertThat(result.get("userid"), is("hong"));
		assertThat(result.get("type"), is("입금"));
		assertThat(result.get("balance"), is(100));
		//assertThat(result.get("eventTime"), is(Date.valueOf("2019-08-20 13:03:39")));
	}

	@Test
	public void testSelectByBean() {
		History result = dao.selectByBean(session, 11);
		assertThat(result.getUserId(), is("hong"));
		assertThat(result.getType(), is("입금"));
		assertThat(result.getBalance(), is(100));
	}

	@Test
	public void testSelectByAll() {
		List<History> hs = dao.selectByAll(session);
		assertThat(hs.size(), is(7));

	}

}

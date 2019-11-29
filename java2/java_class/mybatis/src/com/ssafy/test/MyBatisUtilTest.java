package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.util.MyBatisUtil;

public class MyBatisUtilTest {
	private static Logger logger = LoggerFactory.getLogger(MyBatisUtilTest.class);

	@Before
	public void setUp() throws Exception {
		util = MyBatisUtil.getUtil();
	}

	MyBatisUtil util;

	@Test
	public void test() {
		assertThat(util, is(notNullValue()));
	}

	@Test
	public void testSession() {
		SqlSession session = util.getSession();
		assertThat(session, is(notNullValue()));
		Connection con = session.getConnection();
		logger.trace("Connection: {}", con);
	}
}

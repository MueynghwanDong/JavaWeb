package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ssafy.dao.UserDao;
import com.ssafy.dto.User;
import com.ssafy.util.MyBatisUtil;

public class UserDaoTest {

	UserDao dao;
	SqlSession session;

	@Before
	public void setUp() throws Exception {
		dao = UserDao.getDao();
		session = MyBatisUtil.getUtil().getSession();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testSelectByMap() {
		Map<String, Object> result = dao.selectByMap(session, "hong");
		assertThat(result.get("userid"), is("hong"));
		assertThat(result.get("name"), is("홍길동"));
		assertThat(result.get("balance"), is(130));
	}

	@Test
	public void testSelectByBean() {
		User result = dao.selectByBean(session, "hong");
		assertThat(result.getUserid(), is("hong"));
		assertThat(result.getName(), is("홍길동"));
		assertThat(result.getBalance(), is(130));
	}

	@Test
	public void testSelectByAll() {
		List<User> users = dao.selectByAll(session);
		assertThat(users.size(), is(9));

	}

	@Test
	public void testinsert() {
		// mybatis 에서는 별도 commit을 하지 않으면 rollback 됨
		User user = new User();
		user.setUserid("1111");
		user.setName("dong");
		user.setPass("0000");
		user.setBalance(15000000);
		int result = dao.insert(session, user);
		assertThat(result, is(1));

		User selected = dao.selectByBean(session, user.getUserid());
		assertThat(selected, is(user));

	}

	@Test
	public void testupdate() {
		User user = dao.selectByBean(session, "moon");
		user.setName("dong");
		user.setBalance(123456);

		int result = dao.update(session, user);
		assertThat(result, is(1));

		User selected = dao.selectByBean(session, user.getUserid());
		assertThat(selected, is(user));

	}

	@Test
	public void testupdate2() {
		User user = dao.selectByBean(session, "some_user");

		int result = dao.update(session, user);
		assertThat(result, is(0));

	}

	@Test(expected = PersistenceException.class)
	public void testdelete() {
		User user = dao.selectByBean(session, "hong");

		int result = dao.delete(session, user.getUserid());
		assertThat(result, is(1));
	}

	@Test
	public void testdelete2() {
		User user = new User("temp", "임시", "1234", 100);
		int result = dao.insert(session, user);
		assertThat(result, is(1));

		result = dao.delete(session, user.getUserid());
		assertThat(result, is(1));

		User selected = dao.selectByBean(session, user.getUserid());
		assertThat(selected, is(nullValue()));
	}
}

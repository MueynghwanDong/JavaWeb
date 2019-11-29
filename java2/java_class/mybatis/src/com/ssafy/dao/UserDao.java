package com.ssafy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.dto.User;

public class UserDao {
	private static UserDao dao = new UserDao();

	public static UserDao getDao() {
		return dao;
	}

	private UserDao() {
	}

	private final String namespace = "com.ssafy.mapper.usermapper.";

	public Map<String, Object> selectByMap(SqlSession session, String userid) {
		String stmt = namespace + "selectByMap";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.selectOne(stmt, userid);
	}

	public User selectByBean(SqlSession session, String userid) {
		String stmt = namespace + "selectByBean";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.selectOne(stmt, userid);
	}

	public List<User> selectByAll(SqlSession session) {
		String stmt = namespace + "selectByAll";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.selectList(stmt);
	}

	public int insert(SqlSession session, User user) {
		String stmt = namespace + "insert";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.insert(stmt, user);
	}

	public int update(SqlSession session, User user) {
		String stmt = namespace + "update";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.update(stmt, user);
	}

	public int delete(SqlSession session, String userid) {
		String stmt = namespace + "delete";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.update(stmt, userid);
	}
}

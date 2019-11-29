package com.ssafy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.dto.History;

public class HistoryDao {
	private static HistoryDao dao = new HistoryDao();
	
	public static HistoryDao getDao() {
		return dao;
	}
	private HistoryDao() {
		
	}
	private final String namespace = "com.ssafy.mapper.historymapper.";
	public Map<String, Object> selectByMap(SqlSession session, int historyNo) {
		String stmt = namespace + "selectByMap";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.selectOne(stmt, historyNo);
	}

	public History selectByBean(SqlSession session, int historyNo) {
		String stmt = namespace + "selectByBean";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.selectOne(stmt, historyNo);
	}

	public List<History> selectByAll(SqlSession session) {
		String stmt = namespace + "selectByAll";
		// SqlSession session = MyBatisUtil.getUtil().getSession();
		return session.selectList(stmt);
	}
}

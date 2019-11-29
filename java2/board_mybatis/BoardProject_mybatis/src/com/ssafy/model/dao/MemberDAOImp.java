package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.model.dto.Member;

public class MemberDAOImp implements MemberDAO {

	private static MemberDAOImp impl = new MemberDAOImp();

	public static MemberDAOImp getImpl() {
		return impl;
	}

	private MemberDAOImp() {
	}
	
	private final String ns = "com.ssafy.mapper.MemberMapper.";
	@Override
	public Member search(SqlSession session, String id) {
		String statement = ns+"select";
		return session.selectOne(statement, id);
	}

	@Override
	public List<Member> searchAll(SqlSession session) {
		String statement = ns+"selectAll";
		return session.selectList(statement);
	}

	@Override
	public int add(SqlSession session, Member member) {
		String statement = ns+"insert";
		return session.insert(statement, member);
	}

	@Override
	public int update(SqlSession session, Member member) {
		String statement = ns+"update";
		return session.update(statement, member);
	}

	@Override
	public int remove(SqlSession session, String id) {
		String statement = ns+"delete";
		return session.delete(statement, id);
	}

}

package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.model.dto.Member;

public interface MemberDAO {
	public Member search(SqlSession session, String id) ;

	public List<Member> searchAll(SqlSession session) ;

	public int add(SqlSession session, Member member) ;

	public int update(SqlSession session, Member member) ;

	public int remove(SqlSession session, String id) ;
}

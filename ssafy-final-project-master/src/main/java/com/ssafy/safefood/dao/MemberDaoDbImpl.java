package com.ssafy.safefood.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.safefood.dto.Member;

@Repository
public class MemberDaoDbImpl implements MemberDaoDb {

	@Autowired
	SqlSession session;
	
	private static MemberDaoDbImpl impl = new MemberDaoDbImpl();

	public MemberDaoDbImpl() {
	}

	
	
	public static MemberDaoDbImpl getImpl() {
		return impl;
	}

	private final String namespace = "com.ssafy.mapper.MemberMapper.";

	@Override
	public int insertMember(Member member) {
		String stmt = namespace + "insertMember";
		return session.update(stmt, member);
	}

	@Override
	public Member LoginMember(String id, String pw) {
		String stmt = namespace + "loginMember";
		Member temp = new Member(id, pw, null, null, null, null);
		return session.selectOne(stmt, temp);	//수정
	}

	@Override
	public Member searchMember(String id) {
		String stmt = namespace + "searchMember";
		return session.selectOne(stmt, id);
	}

	@Override
	public int updateMember(Member member) {
		String stmt = namespace + "updateMember";
		return session.update(stmt, member);
	}

	@Override
	public int deleteMember(String id) {
		String stmt = namespace + "deleteMember";
		return session.delete(stmt, id);
	}

	@Override
	public List<Member> searchAll() {
		String stmt = namespace + "searchAll";
		return session.selectList(stmt);
	}
	
	public Member eatMember(String id){
		String stmt = namespace + "eatMember";
		return session.selectOne(stmt, id);
	}



	@Override
	public Member checkLogin(String id) {
		String stmt = namespace + "checklogin";
		return session.selectOne(stmt, id);
	}
	
}

package com.ssafy.safefood.dao;

import java.util.List;

import com.ssafy.safefood.dto.Member;

public interface MemberDaoDb {
	int insertMember(Member member);

	Member LoginMember(String id, String pw);

	Member searchMember(String id);

	int updateMember(Member member);

	public int deleteMember(String id);

	List<Member> searchAll();

	Member eatMember(String id);
	Member checkLogin(String id);
}

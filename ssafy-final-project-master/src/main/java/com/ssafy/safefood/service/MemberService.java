package com.ssafy.safefood.service;

import java.util.List;
import com.ssafy.safefood.dto.Member;

public interface MemberService {
	public Member login(String id, String pw);
	
	public int signup(Member member);
	
	public int update(Member member);
		
	public int delete(String id);

	public Member searchMember(String id);
	
	public List<Member> searchAll();
	
	public Member eatMember(String id);
	
	public 	Member checkLogin(String id);

}

package com.ssafy.safefood.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.safefood.dao.MemberDaoDb;
import com.ssafy.safefood.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDaoDb mdao;
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	private MemberServiceImpl() {
		
	}
	
	//methods
	public Member login(String id, String pw) {
		Member result = null;
		try {
			result = (Member) mdao.LoginMember(id, pw);
		}catch(RuntimeException e) {
			logger.error("로그인 정보 받아오기 실패", e);
		}
		
		return result;
	}
	
	@Transactional
	public int signup(Member member) {
		int result = 0;
		try {
			result = mdao.insertMember(member);
		}catch(RuntimeException e) {
			logger.error("추가 실패", e);
		}
		return result;
	}
	
	@Transactional
	public int update(Member member) {
		int result = 0;
		try {
			result = mdao.updateMember(member);
		}catch(RuntimeException e) {
			logger.error("추가 실패", e);
		}
		
		return result;
	}
	
	
	@Transactional
	public int delete(String id) {
		int result = 0;
		try {
			result = mdao.deleteMember(id);
		}catch(RuntimeException e) {
			logger.error("추가 실패", e);
		}
		
		return result;
	}

	public Member searchMember(String id) {
		Member result = null;
		try {
			result = mdao.searchMember(id);
		}catch(RuntimeException e) {
			logger.error("추가 실패", e);
		}
		return result;
	}
	
	
	public List<Member> searchAll() {
		List<Member> result = mdao.searchAll();
		return result;
	}
	
	public Member eatMember(String id){
		Member result = mdao.eatMember(id);
		return result;		
	}

	@Override
	public Member checkLogin(String id) {
		Member result = null;
		try {
			result = mdao.searchMember(id);
		}catch(RuntimeException e) {
			logger.error("추가 실패", e);
		}
		return result;
	}

}

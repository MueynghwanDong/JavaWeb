package com.ssafy.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.model.dao.MemberDAO;
import com.ssafy.model.dao.MemberDAOImp;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.MemberException;
import com.ssafy.util.MyBatisUtil;

public class MemberServiceImp implements MemberService {
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImp.class);
	
	private MemberDAO dao = MemberDAOImp.getImpl();

	@Override
	public Member search(String id) {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			Member member = dao.search(session, id);

			if (member == null) {
				throw new MemberException("등록되지 않은 아이디입니다.");
			} else {
				return member;
			}
		} catch (RuntimeException e) {
			logger.error("search", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Member> searchAll() {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			return dao.searchAll(session);
		} catch (RuntimeException e) {
			logger.error("search", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}

	@Override
	public boolean login(String id, String pw) {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			Member member = dao.search(session, id);
			if (member == null) {
				throw new MemberException("등록되지 않은 회원 아이디입니다.");
			} else {
				if (pw.equals(member.getPassword())) {
					return true;
				} else {
					throw new MemberException("비밀 번호 오류");
				}
			}
		} catch (RuntimeException e) {
			logger.error("search", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}

	@Override
	public boolean checkID(String id) {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			Member member = dao.search(session, id);
			if (member == null) {
				return false;
			} else {
				return true;
			}
		} catch (RuntimeException e) {
			logger.error("search", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Member member) {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			Member find = dao.search(session, member.getId());
			if (find == null) {
				throw new MemberException("수정할 회원 정보가 없습니다.");
			} else {
				dao.update(session, member);
			}
			session.commit();
		} catch (RuntimeException e) {
			logger.error("search", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(String id) {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			Member find = dao.search(session, id);
			if (find == null) {
				throw new MemberException("탈퇴할 회원 정보가 없습니다.");
			} else {
				dao.remove(session, id);
			}
			session.commit();
		} catch (RuntimeException e) {
			logger.error("search", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}

	@Override
	public void add(Member member) {
		SqlSession session= null;
		try {
			session = MyBatisUtil.getUtil().getSession();
			Member find = dao.search(session, member.getId());
			if (find != null) {
				throw new MemberException("이미 등록된 아이디입니다.");
			} else {
				dao.add(session, member);
			}
			session.commit();
		} catch (RuntimeException e) {
			logger.error("add", e);
			throw new MemberException();
		} finally {
			session.close();
		}
	}
}

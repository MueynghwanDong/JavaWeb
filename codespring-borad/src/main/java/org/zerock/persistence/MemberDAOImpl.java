package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDao {

	@Autowired
	SqlSession sqlSession;
	private static final String ns = "org.zerock.mapper.memberMapper.";

	@Override
	public String getTime() {
		return sqlSession.selectOne(ns + "getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(ns + "insertMember", vo);

	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlSession.selectOne(ns + "selectMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		return sqlSession.selectOne(ns + "readWithPW", paramMap);
	}

}

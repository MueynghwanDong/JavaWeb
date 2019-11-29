package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import annotation.Component;
import vo.Member;

@Component("memberDao")
public class MySqlMemberDao implements MemberDao {
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Member> selectList(HashMap<String, Object> paramMap) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// sql을 실행하는 도구, 이객체가 있어야만 실행할 수 있다.
		// sqlsessionFActory를 통해서만 얻을 수 있다.
		try {
			return sqlSession.selectList("dao.MemberDao.selectList", paramMap);// 맴퍼의 네임스페이스 이름, sql문의
																					// 아이디(selectlist)
		} finally {
			sqlSession.close();
		}
	}

	public int insert(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("dao.MemberDao.insert", member);// 맵퍼 네임스페이스 이름 + sql문 아이디, 값 객체
			sqlSession.commit(); // 임시 데이터베이스에 보관된 작업 결과를 운영 데이터베이스에 적용하라 요청시 사용 하는 메서드
			// 자동 커밋하려면 sqlsession객체 생성시 sqlsession sqlsession =
			// sqlsessionfactory.opensession(true)로 지정
			return count;
		} finally {
			sqlSession.close();
		}
	}

	public int delete(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("dao.MemberDao.delete", no);
			sqlSession.commit();
			return count;

		} finally {
			sqlSession.close();
		}
	}

	public Member selectOne(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("dao.MemberDao.selectOne", no);
		} finally {
			sqlSession.close();
		}
	}

	public int update(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.update("dao.MemberDao.update", member);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

	public Member exist(String email, String password) throws Exception {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("dao.MemberDao.exist", paramMap);

		} finally {
			sqlSession.close();
		}
	}
}

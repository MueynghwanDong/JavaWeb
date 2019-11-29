package dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import annotation.Component;
import vo.Project;

@Component("projectDao")
public class MySqlProjectDao implements ProjectDao {
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Project> selectList(HashMap<String,Object> paramMap) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList("dao.ProjectDao.selectList",paramMap);
		} finally {
			sqlSession.close();
		}
	}

	public int insert(Project Project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert("dao.ProjectDao.insert", Project);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}

	}

	public int delete(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("dao.ProjectDao.delete", no);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

	public Project selectOne(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("dao.ProjectDao.selectOne", no);
		} finally {
			sqlSession.close();
		}
	}
	public int update(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 원래 프로젝트 정보 가져오기 
			Project original = sqlSession.selectOne("dao.ProjectDao.selectOne", project.getNo());

			Hashtable<String, Object> paramMap = new Hashtable<String, Object>();
			// 원래 값과 비교하여 바뀌었다면 Map 객체에 저장
			if (!project.getTitle().equals(original.getTitle())) {
				paramMap.put("title", project.getTitle());
			}
			if (!project.getContent().equals(original.getContent())) {
				paramMap.put("content", project.getContent());
			}
			if (project.getStartDate().compareTo(original.getStartDate()) != 0) {
				paramMap.put("startDate", project.getStartDate());
			}
			if (project.getEndDate().compareTo(original.getEndDate()) != 0) {
				paramMap.put("endDate", project.getEndDate());
			}
			if (project.getState() != original.getState()) {
				paramMap.put("state", project.getState());
			}
			if (!project.getTags().equals(original.getTags())) {
				paramMap.put("tags", project.getTags());
			}
			
			// map객체에 저장된 값이 있다면 update문 실행 없으면 0 반환
			if (paramMap.size() > 0) {
				paramMap.put("no", project.getNo());
				int count = sqlSession.update("spms.dao.ProjectDao.update", paramMap);
				sqlSession.commit();
				return count;
			} else {
				return 0;
			}

		} finally {
			sqlSession.close();
		}
	}

}

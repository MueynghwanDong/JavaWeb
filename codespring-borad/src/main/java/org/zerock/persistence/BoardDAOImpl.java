package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDao {

	@Autowired
	SqlSession session;
	private static String ns = "org.zerock.mapper.BoardMapper.";

	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(ns + "create", vo);

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(ns + "read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(ns + "update", vo);

	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(ns + "delete", bno);

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(ns + "listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(ns + "listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(ns + "listCriterial", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(ns + "countPaging", cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(ns + "listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(ns + "listSearchCount", cri);
	}

	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("bno", bno);
		paramMap.put("amount", amount);

		session.update(ns + "updateReplyCnt", paramMap);

	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		session.update(ns + "updateViewCnt", bno);

	}

	@Override
	public void addAttach(String fullName) throws Exception {
		session.insert(ns + "addAttach", fullName);

	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return session.selectList(ns + "getAttach", bno);
	}

	// 특정 게시물 번호에 속하는 모든 첨부파일 삭제
	@Override
	public void deleteAttach(Integer bno) throws Exception {
		session.delete(ns + "deleteAttach", bno);
	}

	@Override
	public void replaceAttach(String fullName, Integer bno) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("bno_attach", bno);
		paramMap.put("fullName", fullName);
		session.insert(ns + "replaceAttach", paramMap);
	}

}

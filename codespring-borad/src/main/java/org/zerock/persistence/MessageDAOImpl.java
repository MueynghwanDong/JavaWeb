package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace ="org.zerock.mapper.MessageMapper";	
	
	public void create(MessageVO vo) throws Exception {
		
		session.insert(namespace+".create", vo);
	}

	public MessageVO readMessage(Integer mid) throws Exception {

		return session.selectOne(namespace+".readMessage", mid);
	}

	public void updateState(Integer mid) throws Exception {

		session.update(namespace+".updateState", mid);

	}

}
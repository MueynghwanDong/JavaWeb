package com.ssafy.safefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.safefood.dao.QnaDao;
import com.ssafy.safefood.dto.Qna;


@Service
public class QnaServiceImpl implements QnaService{

	@Autowired
	QnaDao qdao;
	
	@Override
	public int regitser(Qna qna) throws Exception {
		return qdao.regitser(qna);
	}

	@Override
	public int update(Qna qna) throws Exception {
		return qdao.update(qna);
	}
	@Override
	public int delete(Integer qnaid) throws Exception {
		return qdao.delete(qnaid);
	}

	@Override
	public Qna selectone(Integer qnaid) throws Exception {
		return qdao.selectone(qnaid);
	}

	@Override
	public List<Qna> qselect() throws Exception {
		return qdao.qselect();
	}

	@Override
	public int aupdate(Qna qna) throws Exception {
		// TODO Auto-generated method stub
		return qdao.aupdate(qna);
	}

	@Override
	public int adelete(Qna qna) throws Exception {
		// TODO Auto-generated method stub
		return qdao.adelete(qna);
	}

	@Override
	public List<Qna> search(String keyword) throws Exception {
		return qdao.search(keyword);
		
	}

	@Override
	public List<Qna> searchWriter(String writer) throws Exception {
		return qdao.searchWriter(writer);
	}

}

package com.ssafy.safefood.dao;

import java.util.List;

import com.ssafy.safefood.dto.Qna;

public interface QnaDao {
	
	public int regitser(Qna qna)throws Exception;
	
	public int update(Qna qna)throws Exception;
	
	public int delete(Integer qnaid) throws Exception;
	
	public Qna selectone(Integer qnaid) throws Exception;
	
	public List<Qna> qselect() throws Exception;
	
	public int aupdate(Qna qna) throws Exception;
	
	public int adelete(Qna qna) throws Exception;
	
	public List<Qna> search(String keyword) throws Exception;
	
	public List<Qna> searchWriter(String writer) throws Exception;
	
}

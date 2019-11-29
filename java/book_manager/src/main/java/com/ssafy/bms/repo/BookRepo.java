package com.ssafy.bms.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.bms.dto.Book;

@Repository
public class BookRepo {
	final String ns ="sql.bms.";
	
	@Autowired
	SqlSession session;
	public Book select(String isbn) {
		return session.selectOne(ns+"select", isbn);
	}
	
	public List<Book> select() {
		return session.selectList(ns+"select");
	}
	public int insert(Book book) {
		return session.insert(ns+"insert",book);
	}
	public int delete(String isbn) {
		return session.delete(ns+"delete",isbn);
	}
	public int update (Book book) {
		return session.update(ns+"update",book);
	}
}

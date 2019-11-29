package com.ssafy.work2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.work.Book;
import day4.work.BookDAO;

public class SearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String by = request.getParameter("by");
		String key = request.getParameter("keyword");
		
		BookDAO dao = BookDAO.getDao();
		
		List<Book> books = dao.findBook(by, key);
		
		return books.toString();
	}

}

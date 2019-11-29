package com.ssafy.work2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import day4.work.Book;
import day4.work.BookDAO;

public class BookListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDAO dao = BookDAO.getDao();
		HttpSession session = request.getSession();
		List<Book> books = dao.listBooks();
		session.setAttribute("books", books);
		
		return "redirect:booklist.jsp";
	}

}

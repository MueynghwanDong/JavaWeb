package com.ssafy.work2.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import day4.work.Book;
import day4.work.BookDAO;


public class AddController implements Controller {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("num1");
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String summary = request.getParameter("summary");
		// 모델 연동
		Book book = new Book(isbn, name, maker, price, summary, 1);
		BookDAO dao = BookDAO.getDao();
		dao.insertBook(book);
		// 마지막 등록 도서 정보 확인을 위해 쿠키 생성

		Cookie cookie = new Cookie("lastBook", URLEncoder.encode(book.toString(), "utf-8"));
		cookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie);

		// 뷰 호출
		HttpSession session = request.getSession();
		List<Book> books = dao.listBooks();
		session.setAttribute("books", books);
		RequestDispatcher disp = request.getRequestDispatcher("booklist.jsp");
		disp.forward(request, response);

		return "redirect:booklist.jsp";
	}

}

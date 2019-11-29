package com.ssafy.day3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MakeCookie
 */
@WebServlet("/MakeCookie")
public class MakeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("id","hong");
		cookie.setMaxAge(60*2);
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("name","홍길동");
		response.addCookie(cookie2); // 유효기간 없는것 :session cookie(브라우저를 닫으면 종료)
		Cookie cookie3 = new Cookie("phone","010-1234-5678");
		cookie3.setMaxAge(0); // 유효기간이 0인 쿠키 => 삭제용
		response.addCookie(cookie3);
		// 전혀 새로운 요청을 발생시킴
		response.sendRedirect("cookieconsumer.jsp");
	}

}

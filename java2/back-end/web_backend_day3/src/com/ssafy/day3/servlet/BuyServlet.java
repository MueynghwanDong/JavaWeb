package com.ssafy.day3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/main/buy")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// cart 정보를 이용해서 서비스 호출 -> 구매 처리
		// 서비스 연동에 문제 없었으면 ->  세션에서 cart 삭제
		HttpSession session = request.getSession();
		System.out.println("구매 처리 : " + session.getAttribute("cart"));
		session.removeAttribute("cart");
		
		response.getWriter().append("success");
	}

}

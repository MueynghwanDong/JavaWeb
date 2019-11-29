package com.ssafy.day3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 확인 - 최초 reqeust 생성시만 생성, 문자열만 가능
		String type = request.getParameter("type");
		System.out.println("type : " + type);
		// attribute 설정
		request.setAttribute("reqAttr", "reqAttr");
		// session 객체 생성
		HttpSession session = request.getSession();
		session.setAttribute("sesAttr", "sesAttr");
		// ServletContext 생성
		ServletContext application = request.getServletContext();
		application.setAttribute("ctxAttr", "ctxAttr");

		String path = "/first.jsp";
		if (type == null || type.equals("forward")) {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + path);
		}

	}
}

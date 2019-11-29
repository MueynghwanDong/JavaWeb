package com.ssafy.day2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.day2.model.RegistService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/member/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 확인
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String[] alergy = request.getParameterValues("alergy");
		// 2. 모델 확인
		RegistService service = new RegistService();
		boolean result = service.regist(name, id, pass, alergy);
		// 3. 모델 결과에 따른 뷰 연결 - SendRedirect or forward
		String page = "loginsuccess.jsp";
		if(!result) {
			page = "loginfail.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);
	}

}

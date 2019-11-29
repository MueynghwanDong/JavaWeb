package com.ssafy.day3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adjava_day4.dto.User;
import adjava_day4.exception.DuplicateException;
import adjava_day4.service.EasyTransService;
import adjava_day4.service.EasyTransServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 파라미터 확인
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String bstr = request.getParameter("balance");
		int balance = bstr != null ? Integer.parseInt(bstr) : 0;
		// 1.1 파라미터에 대한 validation 처리
		System.out.println(userid + " : " + name + " : " + pass + " : " + balance);
		// 2. 모델 연결
		User user = new User(userid,name,pass,balance);
		EasyTransService service = EasyTransServiceImpl.getService();
		try {
			service.regist(user);
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 	// 서버 로깅
			throw new ServletException(e); // 통보
		}
		// 3. 뷰 연결
		RequestDispatcher disp = request.getRequestDispatcher("regist_success.jsp");
		disp.forward(request, response);
	}

}

package com.ssafy.work2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainContoller implements Controller {
	private static final long serialVersionUID = 1L;


	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 확인
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 모델 연결 --> 페이지 연결
		String path = "main.jsp";
		HttpSession session = request.getSession();
		if (id.equals("ssafy") && password.equals("1111")) {
			session.setAttribute("loginId", id);
			session.removeAttribute("errorMsg");
		} else {
			session.setAttribute("errorMsg", "아이디 또는 패스워드가 다릅니다.");
		}
		return "redirect:main.jsp";
	}

}

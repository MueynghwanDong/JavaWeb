package com.ssafy.day4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 확인
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// 모델 이동 - 생략
		// 뷰 연결 -페이지 리턴
		String path = "login.jsp";
		if ("hong".equals(id) && pass.equals("1234")) {
			// 세션에 정보 담기
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			path = "redirect:main.jsp";
		} else {
			// 실패 시 메시지 담기
			request.setAttribute("msg", "아이디/비번확인");
		}
		return path;
	}

}

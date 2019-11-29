package com.ssafy.day4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터 확인
		// 모델 이동 - 생략
		// 뷰 연결 -페이지 리턴
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login.jsp";
	}

}

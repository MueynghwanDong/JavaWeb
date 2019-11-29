package com.ssafy.day4.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 확인
		String name = request.getParameter("name");
		String[] hobby = request.getParameterValues("hobby");
		// 모델 연결 -> 가입 처리
		System.out.println(name + " : " + Arrays.toString(hobby));
		// session에 다음 페이지에서 사용할 데이터 전달
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("loginId", name);
		Cookie cookie = new Cookie("name", name);
		cookie.setMaxAge(60 * 2);
		response.addCookie(cookie);

		return "redirect:regist_result.jsp";
	}

}

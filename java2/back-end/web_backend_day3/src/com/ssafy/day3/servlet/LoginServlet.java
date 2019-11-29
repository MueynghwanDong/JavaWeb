package com.ssafy.day3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adjava_day4.dto.User;
import adjava_day4.exception.UserNotFoundException;
import adjava_day4.service.EasyTransService;
import adjava_day4.service.EasyTransServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 파라미터 확인
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		// 2. 서비스 연동
		String path = "main/main.jsp";
		EasyTransService service = EasyTransServiceImpl.getService();
		try {
			User user = service.login(userId, pass);
			// 사용자가 있다면 -> main.jsp로 이동
			Cookie c = new Cookie("loginId", userId);
			c.setMaxAge(60); // 일반적으로 login cookie는 1달 이상
			response.addCookie(c);
			// 로그인 사용자 정보를 main에 전달할 필요 발생, sendredirect는 request 전달 x
			HttpSession session = request.getSession();
			session.setAttribute("loginId", userId);
		} catch (UserNotFoundException e) { // 조회한 사용자가 없는 경우
			// 사용자가 없다면 -> 실패 페이지로 전환
			path = "login_fail.jsp";
		}
		// 3. 뷰 호출
		response.sendRedirect(path);

	}

}

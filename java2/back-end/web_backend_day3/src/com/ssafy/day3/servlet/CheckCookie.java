package com.ssafy.day3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCookie
 */
@WebServlet("/CheckCookie")
public class CheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//cookie 확인
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				// login 관련 쿠키 여부 확인
				if(c.getName().equals("loginId")) { // 로그인 성공 시 설정
					HttpSession session = request.getSession();
					session.setAttribute("loginId", c.getValue());
					flag = true;
					break;
				}
			}
		}
		// 있다면 -> main.jsp, 없다면 login.jsp
		String path= "main/main.jsp";
		if(!flag) {
			path = "login.jsp";
		}
		// send redirect or forward? - request 전달 ? , url 변경
		response.sendRedirect(path);
	}

}

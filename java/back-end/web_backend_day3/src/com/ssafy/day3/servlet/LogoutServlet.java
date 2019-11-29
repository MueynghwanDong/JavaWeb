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
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/main/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// logout 처리 : 유효기간이 0인 쿠키 사용
		Cookie c = new Cookie("loginId", "some");
		c.setPath(request.getContextPath());// 특정 경로에 path만들기 : 기본 값은 현재 서블릿이 있는 경로
		c.setMaxAge(0); // 클라이언트에 내려가는 즉시 삭제
		response.addCookie(c);
		// 세션 정보 삭제
		HttpSession session = request.getSession();
		session.invalidate();

		String path = "/login.jsp";
		String ctxName = request.getContextPath();
		// sendredirect 의 /는 container root -> context 이름 축 ㅏ필요
		response.sendRedirect(ctxName + path);

		// forward는 / 가 context root =-> context 개입 불필요
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
	}

}

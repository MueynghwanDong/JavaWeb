package com.ssafy.day1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet") // 사용되는 속성이  value 하나뿐인 경우 value 생략 가능 // 배열 요소가 하나뿐일 경우 배열 기호 생략
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("attr", "first");
		if(request.getParameter("type")!=null) {
			//forward로 두번째 서블릿으로 이동
			RequestDispatcher disp = request.getRequestDispatcher("second");
			// request와  response 가 그대로 전달된다.
			disp.forward(request, response);
		}else {
			//send redirect로 두번째 서블릿으로 이동
			response.sendRedirect("second");
		}
	}



}
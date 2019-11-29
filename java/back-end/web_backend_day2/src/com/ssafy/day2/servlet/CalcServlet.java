package com.ssafy.day2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.day2.model.CalcService;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Parameter 검증
		int num1= Integer.parseInt(request.getParameter("num1"));
		int num2= Integer.parseInt(request.getParameter("num2"));
		// 2. service 연결
		CalcService service = new CalcService();
		int result = service.calc(num1, num2);
		 // result가 클라이언트에게 전달되어야 한다. (처음 생긴 값)
		//  파라미터 : 최초 request 가 생설될 때만 만들어짐, 문자열만 가능
		// attribute 필요시 추가 가능, 객체 축4ㅏ 가능
		request.setAttribute("result", result);
		//3. request를 jsp에 전달
		RequestDispatcher disp = request.getRequestDispatcher("calcresult.jsp");
		disp.forward(request, response);
	}

}

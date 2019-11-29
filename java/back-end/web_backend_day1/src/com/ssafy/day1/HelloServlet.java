package com.ssafy.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(description = "난생 처음 만드는 서블릿", urlPatterns = { "/HelloServlet", "/test/hi" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//서블릿 컨텍승트 공유 속성 확인
		ServletContext ctx = request.getServletContext();
		System.out.println(ctx.getAttribute("class"));
		
		String numStr =request.getParameter("num");
		int num = 0;
		if(numStr!=null) {
			num = Integer.parseInt(numStr);
		}
		PrintWriter writer = response.getWriter();
		writer.append("<html><body><h1>");
		
		
		writer.append("Hello Servlet: "+num);
		writer.append("</h1></body></html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

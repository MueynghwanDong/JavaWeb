package com.ssafy.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThreadProblemServlet
 */
@WebServlet("/ThreadProblemServlet")
public class ThreadProblemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		name = request.getParameter("name"); // 공유 변수에 저장
		PrintWriter out = response.getWriter();
		for (int i = 0; i < 10; i++) {
			out.println(name + "님 반갑습니다.");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

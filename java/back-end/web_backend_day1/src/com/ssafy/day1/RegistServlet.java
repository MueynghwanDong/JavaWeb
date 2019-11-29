package com.ssafy.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/member/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// 서블릿 초기화 메서드
		System.out.println("필요한 자원이 있다면 여기서 초기화 가능");
	}

	@Override
	public void destroy() {

		System.out.println("이 서블릿에서 초기화 했던 자원이 있다면 정리");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 확인
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String all[] = request.getParameterValues("alergy");

		// 나중에 service를 호출해 사용자 등록
		System.out.println(name + " " + id + " " + pass);

		// 성공 메시지 출력
		PrintWriter out = response.getWriter();
		out.append("<html><body>" + name + "님의 가입을 환영합니다. "+
		Arrays.toString(all) + "성분을 조심해야 겠군요 </body></html>");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 확인
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		// 나중에 service를 호출해 사용자 등록
		System.out.println(name + " " + id + " " + pass);

		// 성공 메시지 출력
		PrintWriter out = response.getWriter();
		out.append("<html><body>" + name + "님의 가입을 환영합니다.</body></html>");
	}

}

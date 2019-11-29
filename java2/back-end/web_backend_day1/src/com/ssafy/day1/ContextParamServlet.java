package com.ssafy.day1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서블릿에서 ServletContext 획득
		ServletContext ctx = request.getServletContext();
		// ServletContext의 용도 1. 정보제공
		System.out.println("현재 애플리케이션 정보 : " + ctx.getServletContextName());
		// ServletContext의 용도 2. 초기화 파라미터 사용
		String paramName = ctx.getInitParameter("file");
		System.out.println("초기화 파라미터 : " + paramName);
		// ServletContext의 용도 3. 웹 서버 리소스에 대한 inputstream 제공
		InputStream is = ctx.getResourceAsStream(paramName);
		Properties props = new Properties();
		props.load(is);
		System.out.println("읽어들인 내용 : " + props);
		// ServletContext의 용도 3. Servlet Context의 공유 데이터 관리
		ctx.setAttribute("class", "싸피 서울 5반");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

}

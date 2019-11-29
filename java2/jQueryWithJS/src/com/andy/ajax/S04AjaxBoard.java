package com.andy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AJaxServlet
 */
@WebServlet("/AJaxServlet")
public class S04AjaxBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// DB에서 새 글을 조회해 옴
		String message = request.getParameter("message");
		if (message == null) {
			message = "그러게요. 심각하다고 생각하는 1인" + (new Date());
		}
		System.out.println(message);
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> keys = paramMap.keySet();
		for(String key: keys) {
			System.out.println(key+" : "+Arrays.toString(paramMap.get(key)));
		}
		out.println(message);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("글이 등록되었습니다." + request.getParameter("message"));
		doGet(request, response);
	}

}

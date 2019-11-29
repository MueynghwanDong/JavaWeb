package com.andy.ajax;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateionMock
 */
@WebServlet("/ValidateionMock")
public class ValidateionMock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String [] alreadyUsed = {"Hello", "Java", "World"};

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String canUse = request.getParameter("canUse");
		List<String> list = Arrays.asList(alreadyUsed);
		System.out.println(canUse+", "+list.contains(canUse));
		response.getWriter().append(list.contains(canUse)+"");
	}
}

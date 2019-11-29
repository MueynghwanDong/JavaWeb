package com.andy.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class LongTaskServlet
 */
@WebServlet("/LongTaskServlet")
public class LongTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LongTaskServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String param1 = request.getParameter("num1");
		String param2 = request.getParameter("num2");
		int num1, num2 = 0;

		int result = -1;
		String message = null;
		Map<String, Object> data = new HashMap<>();
		try {
			num1 = Integer.parseInt(param1);
			num2 = Integer.parseInt(param2);
			result = num1 * num2;
			data.put("status", "OK");
		} catch (Exception e) {
			message = e.getMessage();
			data.put("status", "FAIL");
		}
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		data.put("result", result);
		data.put("message", message);

		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(data));
	}
}

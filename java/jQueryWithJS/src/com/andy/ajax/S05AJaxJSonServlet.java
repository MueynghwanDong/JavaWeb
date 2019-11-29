package com.andy.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AJaxServlet
 */
@WebServlet("/AJaxJSonServlet")
public class S05AJaxJSonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, String> data = new HashMap<>();
		data.put("name", "홍길동");
		data.put("id", "hong");
		data.put("addr", "율도국");

		Gson gson = new Gson();
		String jsonString = gson.toJson(data);
		System.out.println(jsonString);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("server");

		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json;charset=UTF-8");

		Reader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		Gson gson = new Gson();
		Person person = gson.fromJson(reader, Person.class);
		System.out.println("person: " + person);

		Map<String, String> result = new HashMap<>();
		if (person.getMid().equals("admin")) {
			result.put("message", "OK");
		} else {
			result.put("message", "Fail");
		}

		response.getWriter().write(gson.toJson(result));
	}

	public class Person {

		private String mid;
		private String pass;
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Person() {
		}

		public Person(String id, String pass) {
			mid = id;
			this.pass = pass;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getPass() {
			return pass;
		}

		@Override
		public String toString() {
			return "Person [mid=" + mid + ", pass=" + pass + ", name=" + name + "]";
		}

		public void setPass(String pass) {
			this.pass = pass;
		}

	}
}

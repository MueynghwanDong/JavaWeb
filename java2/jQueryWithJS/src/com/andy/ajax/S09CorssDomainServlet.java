package com.andy.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CorssDomainServlet
 */
@WebServlet("/crossDomainServlet")
public class S09CorssDomainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");

		// 내부적으로 다시 연결
		URL url = new URL(request.getParameter("getUrl"));
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("CONTENT-TYPE", "text/html");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
		String readLine = null;
		StringBuffer sBuffer = new StringBuffer();
		while ((readLine = in.readLine()) != null) {
			sBuffer.append(readLine);
		}
		in.close();
		response.getWriter().append(sBuffer.toString());
	}

}

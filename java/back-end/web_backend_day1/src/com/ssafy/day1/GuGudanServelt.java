package com.ssafy.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GuGudanServelt
 */
@WebServlet("/GuGudanServelt")
public class GuGudanServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String numstr = request.getParameter("num");
		int num =0;
		if(numstr!=null) {
			num = Integer.parseInt(numstr);
		}
		PrintWriter writer = response.getWriter();
		
		writer.append("<html><body><table><tr><th>first</th><th>seconde</th><th>result</th></tr>");
		for (int i = 1; i <= 9; i++) {
				writer.append("<tr><td>" +num + "</td></td>" + i +"</td><td>" + (num*i) +"</td></tr>" );
		}
		writer.append("</table></body></html>");
	}

}

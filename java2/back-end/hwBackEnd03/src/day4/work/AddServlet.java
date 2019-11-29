package day4.work;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("discription");
		// 紐⑤뜽 �뿰�룞
		Product pro = new Product(no,name, price, description);
		

		Cookie cookie = new Cookie("lastpro",URLEncoder.encode(pro.toString(),"utf-8"));
		cookie.setMaxAge(10*60);
		response.addCookie(cookie);
		
		
		
		request.setAttribute("pro", pro);
		RequestDispatcher disp = request.getRequestDispatcher("prolist.jsp");
		disp.forward(request, response);
		//response.sendRedirect("booklist.jsp");
	}

}

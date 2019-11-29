package hw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginController implements Controller {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		if (id.equals("ssafy") && pass.equals("1111")) {
			HttpSession session = request.getSession();
			session.setAttribute("IsLogin", id);
		}
		return "redirect:main.jsp";
		// response.sendRedirect(request.getContextPath() + "/main.jsp");
	}
}
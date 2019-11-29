package hw.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		if(id.equals("ssafy") && pass.equals("1111")) {
			session.setAttribute("IsLogin", id);
		} else {
			session.setAttribute("LoginFail", "LoginFail");
		}
		
		return "redirect:main.jsp";
	}
}

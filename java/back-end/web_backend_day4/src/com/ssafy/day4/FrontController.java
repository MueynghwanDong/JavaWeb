package com.ssafy.day4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.day4.controller.Controller;
import com.ssafy.day4.controller.LoginController;
import com.ssafy.day4.controller.LogoutController;
import com.ssafy.day4.controller.ProblemController;
import com.ssafy.day4.controller.RegistController;

/**
 * Servlet implementation class ExtensionBaseServlet
 */
@WebServlet("*.do") // 경로를 사용하지 않음.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Controller> map = new HashMap<>(); // 초기화 시점

	@Override
	public void init() throws ServletException {
		map.put("/login.do", new LoginController());
		map.put("/logout.do", new LogoutController());
		map.put("/problem.do", new ProblemController());
		map.put("/el/regist.do", new RegistController());
	}

	// 모든 요청은 다 여기를 거쳐간다~
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		Controller controller = map.get(path);
		if (controller == null) {
			path = "login.jsp";
		} else {
			path = controller.execute(request, response);
		}
//		response.getWriter().append("*.do : 확장자 기반 처리" + path);
		// 후처리 : 전달받은 페이지로 이동..
		if (path.startsWith("redirect:")) {
			path = path.substring(path.indexOf(":") + 1);
			response.sendRedirect(path);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}

	}
}

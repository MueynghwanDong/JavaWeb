package day4.work;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 모델 연결
		String path = "main.jsp";
		HttpSession session = request.getSession();
		if(id.equals("ssafy") && password.equals("1111")) {
			session.setAttribute("loginId", id);
		}else {
			session.setAttribute("errorMsg", "아이디 또는 패스워드가 다릅니다.");
		}
		response.sendRedirect(path);
	}

}

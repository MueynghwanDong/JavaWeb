package hw.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw.controller.AddProductController;
import hw.controller.Controller;
import hw.controller.DeleteController;
import hw.controller.ListController;
import hw.controller.LoginController;
import hw.controller.LogoutController;
import hw.controller.TestController;
import hw.controller.UpdateController;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map = new HashMap<String, Controller>();
	
	@Override
	public void init() throws ServletException {
		map.put("/main/addproduct.do", new AddProductController());
		map.put("/login.do", new LoginController());
		map.put("/logout.do", new LogoutController());
		map.put("/productlist.do", new ListController());
		map.put("/main/test.do", new TestController());
		map.put("/main/delete.do", new DeleteController());
		map.put("/main/update.do", new UpdateController());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		Controller controller = map.get(path);
		
		if(controller == null) {
			path = "main.jsp";
		} else {
			path = controller.execute(request, response);
		}
		if (path.startsWith("{")) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().append(path);
		}
		else if(path.startsWith("redirect")) {
			path = path.substring(path.indexOf(":")+1);
			response.sendRedirect(path);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}
	}
}

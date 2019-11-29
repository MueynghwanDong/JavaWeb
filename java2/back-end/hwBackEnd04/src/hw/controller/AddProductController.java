package hw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.dao.ProductDAO;
import hw.dto.Product;

public class AddProductController implements Controller {
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");

		Product product = new Product(id, name, price, description);
		ProductDAO dao = ProductDAO.getDao();
		dao.insertBook(product);
		
		HttpSession session = request.getSession();
		session.setAttribute("recentproduct", product);

		Cookie cookie = new Cookie("recentcookie", "recentproduct");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		
		List<Product> products = dao.listProducts();
		session.setAttribute("products", products);
		RequestDispatcher disp = request.getRequestDispatcher("prodcutlist.jsp");
		disp.forward(request, response);

		return "redirect:prodcutlist.jsp";
		
		// response.sendRedirect(request.getContextPath() + "/main.jsp");
		//return "redirect:main.jsp";
	}
}

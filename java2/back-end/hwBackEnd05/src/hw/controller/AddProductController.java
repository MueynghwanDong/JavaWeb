package hw.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.dao.ProductDAO;
import hw.dto.Product;

public class AddProductController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		int price = Integer.valueOf(request.getParameter("price"));
		String info = request.getParameter("info");
		
		Product product = new Product(number, name, price, info);
		
		HttpSession session = request.getSession();
		session.setAttribute("recentproduct", product);
		
		ProductDAO dao = ProductDAO.getInstance();
		dao.AddProduct(product);
		
		Cookie cookie = new Cookie("recentcookie", "recentproduct");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		
		return "redirect:../main.jsp";
	}
}
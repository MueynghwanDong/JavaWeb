package hw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.dao.ProductDAO;
import hw.dto.Product;

public class ProductListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO dao = ProductDAO.getDao();
		HttpSession session = request.getSession();
		List<Product> products = dao.listProducts();
		session.setAttribute("products", products);
		
		return "redirect:productlist.jsp";
	}

}

package hw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.dao.ProductDAO;
import hw.dto.Product;

public class UpdateController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String targetnum = request.getParameter("targetnumber");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		int price = Integer.valueOf(request.getParameter("price"));
		String info = request.getParameter("info");
		
		ProductDAO dao = ProductDAO.getInstance();
		dao.UpdateProduct(new Product(number, name, price, info), targetnum);
		
		HttpSession session = request.getSession();
		session.setAttribute("Update", "Update");
		
		return "redirect:../productlist.do";
	}
}

package hw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.dao.ProductDAO;

public class DeleteController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String number = request.getParameter("number");
		ProductDAO dao = ProductDAO.getInstance();
		dao.DeleteProduct(number);
		
		HttpSession session = request.getSession();
		session.setAttribute("Delete", "Delete");
		
		return "redirect:../productlist.do";
	}
}
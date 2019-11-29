package hw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hw.dao.ProductDAO;
import hw.dto.Product;

public class TestController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String number = request.getParameter("name");
		System.out.println(number);
		ProductDAO dao = ProductDAO.getInstance();
		Product pro = dao.sellist(number);
		System.out.println(pro);
		Gson gson = new Gson();
		return gson.toJson(pro);
		
		
		//return "redirect:../productlist.do";
	}
}

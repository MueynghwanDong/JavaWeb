package com.ssafy.day3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/main/addCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 추가할 상품 확인
		String goods = request.getParameter("goods");
		// 모델 연동 -> DB에 저장

		// 세션에 방금 담은 상품 추가
		List<String> cartList = null;
		HttpSession session = request.getSession();
		Object cartObj = session.getAttribute("cart"); // 기존에 사용하던 카트 있는지 확인
		if (cartObj != null) {
			cartList = (List) cartObj;// 있다면 그 카트 쓰기
		} else {
			cartList = new ArrayList<>(); // 없었다면 새로 만들고 세션에 등록
			session.setAttribute("cart", cartList);
		}
		cartList.add(goods);
		// 화면 연결 대신 데이터 전달
		response.setContentType("text/plane; charset=utf-8");
		response.getWriter().append(cartList.toString());
	}

}

package com.ssafy.day4.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProblemController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		// runtime 계열의 예외 -> 잘 알아서 전파됨!!
		System.out.println(name.toString());

		try {
			Class.forName("some");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// 서버에게 관련 예외를 전파해주지 않으면 예외 처리 페이지로 연결이 안됨.
			// response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 에러 코드 발생 => 통보
			// or ServletException으로 감싸서 전달하는 방법
			throw new ServletException(e);
		}

		request.setAttribute("name", name);
		return "result.jsp";
	}

}

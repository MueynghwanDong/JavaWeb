package com.ssafy.day5.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServelt
 */
@WebServlet("/upload")
@MultipartConfig(location="c:\\Temp")
public class UploadServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 일반 파라미터
		String desc = request.getParameter("description");
		System.out.println("파일 설명 : " +desc);
		// 파일 처리
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			String orgName = part.getSubmittedFileName();
			if(orgName!=null) {
				part.write(orgName);
			}
		}
		response.getWriter().append("업로드 완료");
		
	}

}

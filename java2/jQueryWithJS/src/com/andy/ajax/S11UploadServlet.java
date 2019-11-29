package com.andy.ajax;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/upload")
public class S11UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		Map<String, String[]> paramMap = req.getParameterMap();
		Set<String> keys = paramMap.keySet();
		System.out.println(keys);
		for(String key: keys) {
			System.out.println(key+" : "+Arrays.toString(paramMap.get(key)));
		}
		String filename = req.getParameter("fileName");
		String desc = req.getParameter("desc");
		System.out.println("업로드 시작: 파일명:"+filename+", 설명: "+desc);
		
		String path = this.getServletContext().getRealPath("/");
		Part file = req.getPart("file");
		byte[] buffer = new byte[256];
		try (InputStream filecontent = file.getInputStream();
				FileOutputStream output = new FileOutputStream(new File(path+"/"+filename));) {
			int len;
			while ((len = filecontent.read(buffer)) > 0) {
				output.write(buffer, 0, len);
			}
		}
		res.getWriter().write(filename + " 업로드 성공");
	}
}

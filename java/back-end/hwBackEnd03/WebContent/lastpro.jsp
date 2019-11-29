<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.net.*,hw.dao.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마지막 등록 상품</h1>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품설명</th>
		</tr>
		<%
			String pro = "";
			String[] str = new String[3];
			try {

				Cookie[] cookies = request.getCookies(); // 요청에서 쿠키를 가져온다

				if (cookies != null) { // 쿠키가 Null이 아닐때,
					System.out.println(cookies.length);
					for (int i = 0; i < cookies.length; i++) {

						if (cookies[i].getName().equals("lastpro")) { // 쿠키의 이름이 id 일때
							 
							pro = URLDecoder.decode((cookies[i].getValue()),"utf-8");

							System.out.println(pro);

							str = pro.split(",");
							System.out.println(str[1]);
						}

					}
				}
			} catch (Exception e) {
			}
			out.println("<tr><td>" + str[0] + "</td><td>" + str[1] + "</td><td>" + str[1] + "</td><td>" + str[2]
					+ "</td></tr>");
		%>
	</table>
	<a href="pro.jsp">상품 등록</a>
</body>
</html>
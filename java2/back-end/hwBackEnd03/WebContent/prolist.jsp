<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*,hw.dao.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 목록 화면</h1>
<jsp:include page="userinfo.jsp"></jsp:include>
<table border="1">
<tr><th>상품 번호</th><th>상품명</th><th>상품가격</th><th>상품설명</th></tr>
<%
Product pro = (Product)request.getAttribute("pro");
out.println("<tr><td>" + pro.getNo() +"</td><td>" + pro.getName() +"</td><td>" + pro.getPrice() + "</td><td>" + pro.getDescription() + "</td></tr>");
	

%>
</table>
<a href = "pro.jsp">상품 등록</a>
</body>
</html>
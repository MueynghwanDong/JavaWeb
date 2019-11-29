<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*,hw.dto.Product" %>    
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
		<tr><th>상품번호</th><th>상품명</th><th>상품가격</th><th>상품 설명</th></tr>

		<c:forEach items="${products}" var="product">
			<tr><td>${product.id}</td><td>${product.name}</td><td>${product.price }</td><td>${product.description }</td></tr>
		</c:forEach>
	</table>
	<a href="product.jsp">도서 등록</a>
</body>

</html>
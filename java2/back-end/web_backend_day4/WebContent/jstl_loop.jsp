<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] arr = { "Hello", "Java", "World" };
		request.setAttribute("arr", arr);
	%>
	<ul>
	<c:forEach begin="1" end="10" step="2" var="i">
		<li>${i }	
	</c:forEach>
	</ul>
	<ul>
	<c:forEach items="${arr }" var="str">
		<li>${str }	
	</c:forEach>
	</ul>
</body>
</html>
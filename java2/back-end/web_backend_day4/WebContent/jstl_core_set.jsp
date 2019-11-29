<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- request.setAttribute("name", "홍길동 ");--%>
	<c:set var="name" value="홍길동" scope="request"></c:set>
	<ul>
		<li><%=request.getAttribute("name") %>
		<li>${name }
	</ul>
	<c:remove var="name"/>
	<%
		request.removeAttribute("name");
	%>
	<ul>
		<li><%=request.getAttribute("name") %>
		<li>${name }
	</ul>
</body>
</html>
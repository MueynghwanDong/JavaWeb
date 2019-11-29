<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 first.jsp</h1>
	<ul>
		<li>파라미터 : <%=request.getParameter("type")%>
		<li>request attr : <%=request.getAttribute("reqAttr")%>
		<li>session attr : <%=session.getAttribute("sesAttr")%>
		<li>application attr : <%=application.getAttribute("ctxAttr")%>
	</ul>
	<a href = "second">두번째 서블릿</a>
</body>
</html>
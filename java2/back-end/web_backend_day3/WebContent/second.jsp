<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 second.jsp</h1>
	<ul>
		<li>파라미터 : <%=request.getParameter("type")%>
		<li>request attr : <%=request.getAttribute("reqAttr")%>
		<li>session attr : <%=session.getAttribute("sesAttr")%>
		<li>application attr : <%=application.getAttribute("ctxAttr")%>
	</ul>
</body>
</html>
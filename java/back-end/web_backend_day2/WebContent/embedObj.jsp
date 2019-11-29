<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체</title>
</head>
<body>
<ul>
<li><%=request %>
<li><%=response %>
<li><%=application %>
<li><%=session %>
<li><%=out %>
</ul>
<h2>request 내장 객체</h2>
<% String param = request.getParameter("name");
out.println("전달 받은 파라미터"  +  param);
%>
<%= "전달받은 파라미터 : " + param %><br>

<%= application.getContextPath() %>


</body>
</html>
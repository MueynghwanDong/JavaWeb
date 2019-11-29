<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 확인</h1>
<ul>
<%
Cookie [] cookies = request.getCookies();
for(Cookie c :cookies){
	out.append("<li>" +c.getName() + " : " + c.getValue());
}
%>
</ul>
</body>
</html>
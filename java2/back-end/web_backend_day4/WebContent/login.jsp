<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<%
		Object msg = request.getAttribute("msg");
		if(msg!=null){
			out.print("<h2>" + msg + "</h2");
		}
	%>
	<form method="post" action="login.do">
		<input type="text" name="id"> 
		<input type="password"name="pass">
		<input type="submit">
	</form>
</body>
</html>
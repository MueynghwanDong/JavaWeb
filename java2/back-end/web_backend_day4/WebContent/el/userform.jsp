<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regist.do" method="get">
		<input type="text" name="name" placeholder="이름"><br> 
		<input type="checkbox" name="hobby" value="sleep">자기<br> 
		<input type="checkbox" name="hobby" value="study">공부<br>
		<input type="checkbox" name="hobby" value="coding">코딩<br>
		<input type="submit">
	</form>
</body>
</html>
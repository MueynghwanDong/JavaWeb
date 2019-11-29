<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><%=request.getParameter("name")%>
		<li>${param.name}						<%-- .표현법 or 배열 표현법 사용 가능 --%>
		<li>${param["name"]}					<%-- 변수 이름에 적합하지 않을 경우는 배열 표현법 --%>
		<li>${header["User-Agent"]}
		<li>${header.User-Agent} 				<%-- 사용 불가 --%>
	</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 Main 입니다.</h1>
	<%=session.getAttribute("loginId")%>님 반갑습니다.
	<!-- 로그아웃 링크 만들고 처리해보기 -->
	<a href="logout.do">로그아웃</a>
</body>
</html>
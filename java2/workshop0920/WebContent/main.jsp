<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<body>
	<div class="container">
		<c:if test="${errorMsg!=null }">
			<h2>${errorMsg }</h2>
		</c:if>
		<c:choose>
			<c:when test="${loginId==null }">
			<c:url value="/login.do" var="url"></c:url>
				<form method="post" action="${url }">
					로그인해주세요. <br>
					<table id="logintable">
						<tr>
							<td>ID</td>
							<td><input type="text" id="id" name="id">
						</tr>
						<tr>
							<td>PASSWORD</td>
							<td><input type="password" id="password" name="password">
						</tr>
					</table>
					<input type="submit" value="LOGIN" id="submit">
				</form>
				<a href="book.jsp">도서등록</a>
				<c:url value="/list.do" var="list"></c:url> 
				<a href="${list }">도서목록</a>
				<a href="#">마지막 등록한 도서</a>
			</c:when>
			<c:otherwise>
		${loginId }님 로그인 되었습니다. <br>
				<a href="book.jsp">도서등록</a>
				<c:url value="/list.do" var="list"></c:url> 
				<a href="${list }">도서목록</a>
				<c:url value="/logout.do" var="logout"></c:url> 
				<a href="${logout }">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>

<script>
	$("#logintable").css({
		border : "1px solid black"
	});
</script>
</html>
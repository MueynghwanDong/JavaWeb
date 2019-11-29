<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<c:if test="false">
		<h1>안녕하세요.</h1>
	</c:if>
	<c:if test="${param.user=='member' }">
		<h1>멤버 페이지로 이동합니다.</h1>
	</c:if>
	<c:if test="${param.user=='guest' }">
		<h1>게스트 페이지로 이동합니다.</h1>
	</c:if>

	<c:choose>
		<c:when test="${param.user=='member' }">
			<h1>멤버 페이지로</h1>
		</c:when>
		<c:when test="${param.user=='guset' }">
			<h1>게스트 페이지로</h1>
		</c:when>
		<c:otherwise>
			<h1>어디로 가나요...</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>
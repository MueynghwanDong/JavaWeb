<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 공통 모듈들 작성 -->
<c:url value="/css/basic.css" var="css"></c:url>
<link rel="stylesheet" href="${css }">
</head>

<c:if test="${!empty loginUser }">
	${loginUser.id }님 로그인 되었습니다.<a href="logout.do">로그아웃</a>
</c:if>

<h1>${title }</h1>
<!--  jqery loading -->
<script src="<c:url value = '/js/jqery-3.3.1.js'/>"></script>
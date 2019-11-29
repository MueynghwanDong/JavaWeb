<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안전 먹거리</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link type="text/css" href="css/css.css" rel="stylesheet" />

<style>
</style>


</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="detail">
		<div id="result" class="container">
			<h2 class="high_light middle">
				<b>사이트 맵</b>
			</h2>
			<hr>
			<table class="table middle">
				<tr>
					<td><span class="high_light"><a href="index.jsp" />홈으로</span></td>
				</tr>
				<tr>
					<td><span class="high_light"><a href="board.do" />공지 사항</span></td>
				</tr>
				<tr>
					<td><span class="high_light"><a href="foodlist.do" />상품 정보</span></td>
				</tr>
				<tr>
					<td><span class="high_light"><a href="best.do" />베스트 섭취 정보</span></td>
				</tr>
				<tr>
					<td><span class="high_light"><a href="qna" />QnA</span></td>
				</tr>
				<c:if test="${empty member}">
					<tr>
						<td><span class="high_light"><a href="login.do" />로그인</span></td>
					</tr>
				</c:if>
				<tr>
					<td><span class="high_light"><a href="memberlist.do" />회원 목록</span></td>
				</tr>
				<c:if test="${not empty member}">
					<tr>
						<td><span class="high_light"><a href="memberinfo.jsp" />회원 정보</span></td>
					</tr>
					<tr>
						<td><span class="high_light"><a href="membereat.do" />내 섭취 정보</span></td>
					</tr>
					<tr>
						<td><span class="high_light"><a href="jjim.do" />찝한 목록 보기</span></td>
					</tr>
				</c:if>
			</table>
			<hr>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
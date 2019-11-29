<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<style>
#test {
	background: #BDBDBD;
}

#star {
	color: red;
}
</style>

<body>
	<div class="container">
		<h2 class="text-center" id="backgroundcolor">상품 등록 화면</h2>
		<jsp:include page="userinfo.jsp"></jsp:include>
		<c:url value="/addProduct.do" var="url"></c:url>
		<form method="post" action="${url }">

			<table class="table table-condensed">
				<tbody>
					<tr>
						<td></td>
						<td class="text-right"><span id="star">*</span> 표시가 된 항복은 필수
							입력 항목입니다.</td>
					</tr>

					<tr>
						<td id="test"></td>
						<td id="test"></td>
					</tr>

					<tr>
						<td><span id="star">*</span> 상품번호</td>
						<td><input type="text" id="id" name="id"></td>
					</tr>

					<tr>
						<td><span id="star">*</span> 상품명</td>
						<td><input type="text" id="name" name="name"></td>
					</tr>
					<tr>
						<td><span id="star">*</span> 상품가격</td>
						<td><input type="text" id="price" name="price"></td>
					</tr>

					<tr>
						<td>* 상품설명</td>
						<td id="test"><textarea id="description" name="description"></textarea>
						</td>
					</tr>
				</tbody>
			</table>

			<input type="submit" value="상품등록" id="submit"> 
			<input type="button" value="취 소" id="cancel">
		</form>
	</div>
</body>

</html>
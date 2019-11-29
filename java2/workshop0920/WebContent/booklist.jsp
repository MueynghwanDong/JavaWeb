<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*,day4.work.Book" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 목록 화면</h1>
	<jsp:include page="userinfo.jsp"></jsp:include>
	<select id ="by">
	<option value="title">제목
	<option value="publisher">출판사
	<option value="price">가격
	</select>
	<input type = "text" name ="keyword" id ="keyword">
	<input type = "button" id ="select" value="조회">
	<table border="1">
		<tr><th>도서번호</th><th>도서명</th><th>도서가격</th><th>출판사</th></tr>

		<c:forEach items="${books}" var="book">
			<tr><td>${book.isbn}</td><td>${book.title}</td><td>${book.price }</td><td>${book.publisher }</td></tr>
		</c:forEach>
	</table>
	<a href="book.jsp">도서 등록</a>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$("#select").on("click",function(){
	$.ajax({
		url:"search.do",
		method:"post",
		data:"by=" + $("#by").val()+"&keyword=" +$("#keyword").val()
	})
})
</script>
</html>
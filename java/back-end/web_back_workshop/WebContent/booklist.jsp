<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*,hw.dao.Book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>도서 목록 화면</h1>
<jsp:include page="userinfo.jsp"></jsp:include>
<table border="1">
<tr><th>도서번호</th><th>도서명</th><th>도서가격</th><th>출판사</th></tr>
<%
List<Book> books = (List)request.getAttribute("books");
for(Book book: books){
	out.println("<tr><td>" + book.getIsbn() +"</td><td>" + book.getTitle() + "</td>");
	out.println("<td>" + book.getPrice() + "</td><td>" + book.getPublisher() + "</td></tr>");
	
}

%>
</table>
<a href = "book.jsp">도서 등록</a>
</body>
</html>
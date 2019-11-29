<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--exception 내장 객체 사용 가능 --%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>죄송합니다. 잠시 후 다시 시도해주세요</h1>
<div><%=exception %></div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
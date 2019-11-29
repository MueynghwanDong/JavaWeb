<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page errorPage="sorry.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<%-- num1, num2를 파라미터로 받아서 결과를 출력 --%>
	<%
		// request 라고 쓸 수 있는 이유는?
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
	%>
	<%=num1 %> + <%=num2 %> = <%=num1 + num2 %>
	<h1>현재 시각은</h1>
	<%@ include file="sub.jsp" %>
	<%=getNow() %>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
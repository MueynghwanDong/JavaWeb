<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<!-- 이것은 HTML 주석 -->
	<%
		String name = "홍길동";
	%>

	<%-- 이것은 JSP 주석 --%>
	
	<%! 
	public String sayHello(String name) {
		return "Hello" + name + Calendar.getInstance();
	}
	%>
	<%=sayHello(name) %>
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>
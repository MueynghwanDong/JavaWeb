<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>locale 정보</h2>
	<ul>
		<c:set var="money" value="123456789" />
		<%
			Date d = new Date();
			request.setAttribute("now", d);
		%>
		<!-- locale : 언어, 국가, set : 언어, 통화, 기호, 천단위 구분다 -->
		<li>기본 locale: <%=response.getLocale()%>
		<li>${money }
		<li><fmt:formatNumber value="${money }" type="currency"></fmt:formatNumber>
		<li>${now }
		<li><fmt:formatDate value="${now }" type = "date"/>
		<li><fmt:formatDate value="${now }" type = "time"/>
		<li><fmt:formatDate value="${now }" type = "both"/>
		<li><fmt:formatDate value="${now }" pattern = "yyyy/MM/dd(E)"/>
		<li><fmt:bundle basename="message.message">
				<fmt:message key="title"/>
				<fmt:message key="name"/> 홍길동 <br>
				<fmt:message key="age"/> 30 <br>
				<fmt:message key="welcome">
				<fmt:param value="장길산"/>
				</fmt:message>
		</fmt:bundle>
			<fmt:setLocale value="en_US" />
		<li>변경 locale: <%=response.getLocale()%>
		<li><fmt:formatNumber value="${money }" type="currency"></fmt:formatNumber>
		<li><fmt:formatDate value="${now }" type = "date"/>
		<li><fmt:formatDate value="${now }" type = "time"/>
		<li><fmt:formatDate value="${now }" type = "both"/>
		<li><fmt:formatDate value="${now }" pattern = "yyyy/MM/dd(E)"/>
		<li><fmt:bundle basename="message.message">
				<fmt:message key="title"/>
				<fmt:message key="name"/> 홍길동 <br>
				<fmt:message key="age"/> 30 <br>
				<fmt:message key="welcome">
				<fmt:param value="장길산"/>
				</fmt:message>
		</fmt:bundle>
	</ul>
</body>
</html>

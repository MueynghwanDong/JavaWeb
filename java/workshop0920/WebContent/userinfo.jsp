<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${loginId }님 로그인 되었습니다.
<c:url value="/logout.do" var="url"></c:url>
<a href="${url }">로그 아웃</a>
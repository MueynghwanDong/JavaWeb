<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%-- 자기 혼자서 동작할 필요는 없는 페이지 --%>

<%-- 현재 시스템 시간 표시 가능 --%>

<%! public String getNow(){
	Calendar c = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd(E)");
	return format.format(c.getTime());
}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String numstr = request.getParameter("num");
int num =1;
if(numstr!=null) {
	num = Integer.parseInt(numstr);
}
%>
	<table border="1">
		<tr>
			<th>first</th>
			<th>second</th>
			<th>result</th>
		</tr>
		<%
		for(int i =1; i<10; i++){
			%>
			<tr>
			<td> <%= num %> </td>
			
			<td> <%= i %> </td>
			
			<td> <%= num * i %> </td>
			</tr>
			<%
		}
		%>
	</table>

</body>
</html>
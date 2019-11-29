<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.middle {
	text-align: center;
}

.right {
	text-align: right;
}

.bg-silver {
	background: silver;
}

table td {
	border: 1px solid;
}

div {
	border: 1px solid;
	text-align: center;
	width: 300px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<h1>메인 페이지</h1>

		<%
			Object loginId = session.getAttribute("loginId");
			Object errorMsg = session.getAttribute("errorMsg");
			if(errorMsg!=null){
				out.print("<h2>" + errorMsg+"</h2>");
			}
			if (loginId == null) {
		%>
		<form name="login" method="post" action="MainServlet">
			<table>
				<tr height="200px">
					<td><img width="150px" />이미지</td>
					<td>
						<p class="middle">로그인하여 주세요</p>
						<table>
							<tr>
								<td class="right">id</td>
								<td><input type="text" name="id" id="id" /></td>
							</tr>
							<tr>
								<td class="right">password</td>
								<td><input type="password" name="password" id="password" /></td>
							</tr>
							<tr>
								<td class="right"></td>
								<td>
									<hr> <input type="submit"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
		<a href="Book.jsp">도서 등록</a> <a href="#">도서 목록 </a> <a href="#">마지막 등록 도서</a>
		<%
			} else {
				// 로그인 한 경우라면 ...
		%>
		<%=loginId%>님 로그인 되었습니다. <a href="Book.jsp">도서 등록</a> <a href="LogoutServlet">로그 아웃
		</a>
		<%
			}
		%>
	

</body>
<br />


</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 되었습니다.</h1>
	<h2>가입하신 정보는 다음과 같습니다.</h2>
	<ul>
		<li> ${sessionScope.name}
		<li> ${name}
		<li> ${hobby[0]}, ${hobby[1]},${hobby[2]}
		<li> ${cookie.name.value}
		<li> ${loginId}
		<li> ${empty loginId? "guest" : loginId} 님 반갑습니다.
	</ul>
</body>
</html>
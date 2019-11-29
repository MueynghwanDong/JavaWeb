<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 수정</h1>
	<form method="post" action="update.do">
		변경할 상품 번호를 입력하세요 : <input type="text" name="targetnumber"> <br>
		
		변경 될 상품 내역을 입력하세요
		<table>
			<tr>
				<td>상품번호</td>
				<td><input type="text" name="number"> </td>
			</tr>
			
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name"> </td>
			</tr>
			
			<tr>
				<td>상품가격</td>
				<td><input type="text" name="price"> </td>
			</tr>
			
			<tr>
				<td>상품설명</td>
				<td><input type="text" name="info"> </td>
			</tr>
		</table>
		<input type="submit" value="변경하기">
	</form>
</body>
</html>
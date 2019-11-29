<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h2>상품 등록 화면</h2>
<jsp:include page ="userinfo.jsp"></jsp:include>
<br>
		
<h2>상품을 입력해주세요</h2>
<form action ="addServlet" method="post">
상품 번호 : <input type = "text" name ="no" id ="no"><br>
상품 명 : <input type = "text" name ="name"id="name"> <br>
상품 가격 : <input type = "text" name ="price" id ="price"> <br>
상품 설명 : <input type = "text" name = "discription" id =discription><br>
<input type ="submit" value ="저장">
<input type = "reset" value ="취소">
</form>
</body>
</html>
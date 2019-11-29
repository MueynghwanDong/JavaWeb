<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 메인입니다.</h1>
	<span><%=session.getAttribute("loginId") %>님 반갑습니다.</span>
	
	<a href="logout">로그 아웃</a>
	<hr>
	<input type = "text" id = "goods"><input type="submit" value = "장바구니 담기" id ="addCart">
	<h2>장바구니 내용</h2>
	<ul id = "cart"></ul>
	<input type ="submit" value ="구매" id ="buy"> 
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
//addCart 클릭 시 장바구니에 추가 ->ajax 호출
$("#addCart").on("click", function(){
	$.ajax({
		url:"addCart",
		type:"post",
		data:"goods="+$("#goods").val(),
		success:function(resData){
			//console.log(resData);
			$("#cart").empty();
			$("#cart").append("<li>" + resData);
		},
		error : function(){
			alert("카트추가 실패");
		}
	});
});
//buy 클릭시 장바구니 비우기 
$("#buy").on("click", function(){
	$.ajax({
		url:"buy",
		success:function(resData){
			console.log(resData);
			if(resData=="success"){
				$("#cart").empty();
				$("#cart").append("<li>장바구니가 비었습니다." );
			}
		},
		error : function(){
			alert("구매 실패");
		}
	});
});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>rest service</h1>
	<h1>도서 목록</h1>
	<ul id="list">
	</ul>
	<input type="button" value="추가" id="btnAdd">
	<input type="button" value="수정" id="btnMod">
	<input type="button" value="삭제" id="btnDel">
	<br>
	<label for="isbn">isbn</label>
	<input type="text" id="myisbn">
	<br>
	<label for="title">제목</label>
	<input type="text" id="mytitle">
	<br>
	<label for="author">저자</label>
	<input type="text" id="myauthourno">
	<br>
	<label for="price">가격</label>
	<input type="text" id="myprice">
	<br>
	<label for="publisher">출판사</label>
	<input type="text" id="mypublisher">
	<br>
	<label for="descripton">설명</label>
	<textarea cols="40" rows="10" id="mydescription"></textarea>
	<div id="result"></div>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function list() {
		$.ajax({
			url : "/rest/book",
			type : "get",
			success : function(resTxt) {
				if (resTxt.status) {
					$("#list").empty();
					let data = resTxt.data;
					$(data).each(function(idx, item) {
						$("#list").append("<li class ='isbn'>" + item.isbn+"</li>")
					})
				} else {
					alert("조회 오류");
				}
			},
			error : function(xhr) {
				alert("조회오류");
			}
		});
	}
	list();
	
	$("ul").on("click", ".isbn", function() {
		let num = $(this).text();
		$.ajax({
			url: "/rest/book/"+num,
			type: "get",
			success: function(resTxt) {
				let data = resTxt.data; 
				console.log(data);
				$("#myisbn").val(data.isbn);
				$("#mytitle").val(data.title);
				$("#myauthourno").val(data.authourno);
				$("#myprice").val(data.price);
				$("#mypublisher").val(data.publisher);
				$("#mydescription").val(data.description);
				
				$("#result").text("조회 성공");
			},
			error: function(error) {
				$("#result").text("목록 조회 실패");
			}
		});
	});
	
	$("#btnAdd").on("click", function() {
		let obj = {
				isbn: $("#myisbn").val(),
				title: $("#mytitle").val(),
				authourno:$("#myauthourno").val(),
				price:$("#myprice").val(),
				publisher:$("#mypublisher").val(),
				description:$("#mydescription").val()

				};
		
		$.ajax({
			url: "/rest/book/insert",
			type: "post",
			data: JSON.stringify(obj), // 객체 -> 문자열
			contentType: "application/json", // 이제 json 형태로 보낼꺼다~
			success: function(resTxt) {
				if(resTxt.status) {
					$("#result").text("추가 성공");
					list();
					//list("데이터 추가 성공");
				}
			},
			error: function(error) {
				$("#result").text(error+ "데이터 추가 실패");
			}
		});
	});
	
	$("#btnMod").on("click", function() {
		let obj = {
				isbn: $("#myisbn").val(),
				title: $("#mytitle").val(),
				authourno:$("#myauthourno").val(),
				price:$("#myprice").val(),
				publisher:$("#mypublisher").val(),
				description:$("#mydescription").val()

				};
		
		$.ajax({
			url: "/rest/book/update",
			type: "put",
			data: JSON.stringify(obj),
			contentType: "application/json",
			success: function(resTxt) {
				if(resTxt.status) {
					$("#result").text("데이터 변경 성공");
				}
			},
			error: function(error) {
				$("#result").text("데이터 변경 실패");
			}
		});
	});
	
	$("#btnDel").on("click", function() {
		$.ajax({
			url: "/rest/book/delete/"+$("#myisbn").val(),
			type: "delete",
			success: function(resTxt) {
				if(resTxt.status) {
					$("#result").text("데이터 삭제 성공");
				}
			},
			error: function(error) {
				$("#result").text("데이터 삭제 실패");
			}
		});
	});
</script>
</html>
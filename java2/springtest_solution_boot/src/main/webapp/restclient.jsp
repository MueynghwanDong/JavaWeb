<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 폰 목록 조회</h1>
	<table border="1">
		<tr>
			<th>num</th>
			<th>model</th>
			<th>제조사</th>
			<tbody id="phones">
			</tbody>
		</tr>
	</table>
	
	<h1>선택 폰 정보 - 리스트에서 num 선택 시 아래 내용을 채워보세요.</h1>
	<label for="num">번호</label><input type="text" id="mynum"><br>
	<label for="model">모델</label><input type="text" id="mymodel"><br>
	<label for="price">가격</label><input type="text" id="myprice"><br>
	<label for="vcode">제조사</label>
	<select id="myvcode">
		<option value="10">삼성
		<option value="20">엘지
		<option value="30">애플
	</select>
	
	<input type="button" value="추가" id="btnAdd">
	<input type="button" value="수정" id="btnMod">
	<input type="button" value="삭제" id="btnDel">

	<div id="result"></div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function list(data) {
		$("#result").text(data);
		
		$.ajax({
			url: "http://localhost:8080/BoardSpringMVCMybatis/pms/rest/selectAll",
			method: "get",
			success: function(resTxt) {
				// console.log(resTxt);
				if(resTxt.status) {
					$("#phones").empty();
					
					let data = resTxt.data;
					$.each(data, function(idx, item) {
						let $tr = $("<tr>");
						$tr.append("<td class='num'>"+item.num+"</a></td>");
						$tr.append("<td>"+item.model+"</td>");
						$tr.append("<td>"+item.comp.vendor+"</td>");
						$tr.append($("</tr>"));
						$("#phones").append($tr);
					});
				}
			},
			error: function(error) {
				$("#result").text("목록 조회 실패");
			}
		});
	}
	
	list();
	
	$("tbody").on("click", ".num", function() {
		let num = $(this).text();
		$.ajax({
			url: "http://localhost:8080/BoardSpringMVCMybatis/pms/rest/select/$"+num,
			type: "get",
			success: function(resTxt) {
				let data = resTxt.data; 
				//console.log(data);
				$("#mynum").val(data.num);
				$("#mymodel").val(data.model);
				$("#myprice").val(data.price);
				$("#myvcode").val(data.vcode);
			},
			error: function(error) {
				$("#result").text("목록 조회 실패");
			}
		});
	});
	
	$("#btnAdd").on("click", function() {
		let obj = {
				  model: $("#mymodel").val(),
				  num: $("#mynum").val(),
				  price: $("#myprice").val(),
				  vcode: $("#myvcode").val()
				};
		
		$.ajax({
			url: "http://localhost:8080/BoardSpringMVCMybatis/pms/rest/phone",
			type: "post",
			data: JSON.stringify(obj), // 객체 -> 문자열
			contentType: "application/json", // 이제 json 형태로 보낼꺼다~
			success: function(resTxt) {
				if(resTxt.status) {
					list("데이터 추가 성공");
				}
			},
			error: function(error) {
				$("#result").text("데이터 추가 실패");
			}
		});
	});
	
	$("#btnMod").on("click", function() {
		let obj = {
				  model: $("#mymodel").val(),
				  num: $("#mynum").val(),
				  price: $("#myprice").val(),
				  vcode: $("#myvcode").val()
				};
		
		$.ajax({
			url: "http://localhost:8080/BoardSpringMVCMybatis/pms/rest/update",
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
			url: "http://localhost:8080/BoardSpringMVCMybatis/pms/rest/delete/$" + $("#mynum").val(),
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
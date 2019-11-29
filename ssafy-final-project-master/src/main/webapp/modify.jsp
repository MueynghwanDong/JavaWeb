<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안전 먹거리</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link type="text/css" href="css/css.css" rel="stylesheet" />

<style>
</style>


</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="detail">
		<div id="result" class="container">
			<h2 class="high_light middle">
				<b>공지사항</b>
			</h2>
			<hr>
			<form role="form" action="modify.do" method="post">

				<input type='hidden' name='page' value="${cri.page}">
				<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
				<input type='hidden' name='searchType' value="${cri.searchType}">
				<input type='hidden' name='keyword' value="${cri.keyword}">

				<div class="box-body">

					<div class="form-group">
						<label for="exampleInputEmail1">BNO</label>
						<input type="text" name='bno' class="form-control" value="${board.bno}" readonly="readonly">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" name='title' class="form-control" value="${board.title}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3">${board.content}</textarea>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label>
						<input type="text" name="writer" class="form-control" value="${board.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<div>
						<hr>
					</div>

					<ul class="mailbox-attachments clearfix uploadedList">
					</ul>

					<input type="button" id ="btn-warning" class="btn btn-warning" value="CANCEL">
					<c:if test="${member.name == board.writer}">
					<button type="submit" id="sbutton" class="btn btn-primary">Modify</button>
						<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
					</c:if>
				</div>
			</form>

			<hr>
			<button type="submit" class="btn btn-primary" id="goListBtn">GO LIST</button>

			<c:if test="${empty member}">
				<div class="box-body">
					<div>
						<a href="javascript:goLogin();">Login Please</a>
					</div>
				</div>
			</c:if>
		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
<script>
$("#commit").on("click", ()=>{
	location.href='./foodsearch.html?cat='+search+'&word='+$("#word").val();
})

$("#word").on("keydown", (key)=>{
	if(key.keyCode == 13){
		$("#commit").trigger("click");
	}
}) 
</script>

<script>
let bno = ${board.bno};
console.log(bno);
$(document).ready(function(){	
	$("#btn-warning").on("click", function(){
	  self.location = "/board.do?page=${cri.page}&perPageNum=${cri.perPageNum}"+
			  "&searchType=${cri.searchType}&keyword=${cri.keyword}";
	});

	
	$("#modifyBtn").on("click", function(){
		formObj.attr("action", "modfiy.do");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
 	$("#removeBtn").on("click", function(){
 		console.log("/remove.do?bno="+${board.bno});
		self.location= "/remove.do?bno=${board.bno}";
	});
	
	$("#goListBtn").on("click", function(){
		self.location = "/board.do?page=${cri.page}&perPageNum=${cri.perPageNum}"+
		  "&searchType=${cri.searchType}&keyword=${cri.keyword}";
	});	
});


function goLogin(){
	self.location ="login.jsp";
}
</script>
<script src="search.js"></script>
</html>
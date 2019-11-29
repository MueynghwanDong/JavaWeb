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
			<form id='registerForm' method="post" action="registerboard.do">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<input type="text" id = "title" name='title' class="form-control" placeholder="Enter Title">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" id ="content"  name="content" rows="3" placeholder="Enter ..."></textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label>
						<input type="text" name="writer" class="form-control" value="${member.id }" readonly>
					</div>
				</div>

				<button type="submit" id = "sbutton" class="btn btn-primary">Submit</button>
			</form>
			<hr>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
<script>
$("#sbutton").on("click",function(){
	$(this).attr();
});
$("#commit").on("click", ()=>{
	location.href='./foodsearch.html?cat='+search+'&word='+$("#word").val();
})

$("#word").on("keydown", (key)=>{
	if(key.keyCode == 13){
		$("#commit").trigger("click");
	}
}) 
</script>
<script src="search.js"></script>
</html>
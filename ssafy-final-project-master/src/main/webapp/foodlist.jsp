<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안전 먹거리</title>

<link type="text/css" href="css/css.css" rel="stylesheet" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.fly {
	float: right;
}
</style>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>


	<div id="detail">
		<div id="result" class="container">
			<h2 class="high_light middle">
				<b>상품 정보</b>
			</h2>

			<div class="dropdown fly">
				<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
					data-toggle="dropdown" aria-expanded="true">
					정렬 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1" href="#" id="view">View</a></li>
				</ul>
			</div>
			<br>
			<div id="print">
				<c:forEach items="${foods}" var="food">
					<div class="row">
						<div class="col-md-3">
							<img src="${food.img}" height="200px" width="200px" />
						</div>
						<div class="col-md-9">
							<!-- ?? -->
							<table id="" class="table">
								<tr onclick="javascript:moveFoodInfo('${food.code}')">
									<td><h3 class="high_light">${food.name}</h3> <span><b>${food.maker}</b></span><span
										class="fly">&nbsp;${food.frequency}</span><span class="
glyphicon glyphicon-eye-open fly"></span></td>
								</tr>
								<tr>
									<td>${food.material}</td>
								</tr>
								<tr>
									<td id="allergy">알레르기 주의 성분 : ${food.allergy}</td>

<%-- 									<c:if test="${not empty member}"> --%>
<%-- 										<td onclick="check('${food.allergy }')" id="allimg"></td> --%>
<%-- 									</c:if> --%>
								</tr>

							</table>
						</div>
					</div>
					<br>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>

<script>
function check(allergy){
	
let ftr = allergy;
console.log(allergy);
let frr = ftr.split(',');
let str = "${mallergy}";
let srr = str.split('/');
let c = false;
for(var i = 0; i<srr.length;i++){
	for(var j = 0; j<frr.length;j++){
		if(srr[i] == frr[j])
			c = true;
	}	
}
if(c){
	console.log("SDf");
	let a = (document.getElementById("allimg"));
	a.style.backgroundColor = "red";
}
	
}
// let check = (allergy) =>{
// 	console.log(allergy);
// }

let moveFoodInfo = (code) => {
	location.href="./foodview.do?code="+code;
}

$("#view").on("click", ()=>{
 	location.href="./foodsortlist.do";
	
	
})

</script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<script src="search.js"></script>

</html>
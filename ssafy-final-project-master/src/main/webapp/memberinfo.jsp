<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGNUP - SAFEFOOD</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" href="css/css.css" rel="stylesheet" />

<script src="search.js"></script>
<style>
	.mybutton{
		width:100%;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="login_form" class="login container">
		<form class="form-horizontal" method="post" id="fm">
			<div class="login_title">
				<h3 class="high_light middle">회원정보</h3>
			</div>
			<hr>
			
			<div class="row form-group">
				<label for="inputid3" class="col-sm-4 control-label">아이디</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="id" value="${member.id }"
						placeholder="ID" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="inputid3" class="col-sm-4 control-label">비밀번호</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="pw" value="${member.pw }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputid3" class="col-sm-4 control-label">이름</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="name" value="${member.name }"
						placeholder="Name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputid3" class="col-sm-4 control-label">전화번호</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="phone" value="${member.phone }"
						placeholder="Phone">
				</div>
			</div>
			<div class="form-group">
				<label for="inputid3" class="col-sm-4 control-label">이메일</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="email" value="${member.email }"
						placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputid3" class="col-sm-4 control-label">알레르기</label>
				<div class="col-sm-5">
<!-- 				 "대두", "땅콩", "우유", "게", "새우", "참치", "연어", "쑥", "소고기", "닭고기", "돼지고기", "복숭아", "민들레", "계란흰자" -->
					<input id = "대두" name="allergy" value="0" type="checkbox"><label for="0">대두</label>
					<input id = "땅콩" name="allergy" value="1" type="checkbox"><label for="1">땅콩</label>
					<input id = "우유" name="allergy" value="2" type="checkbox"><label for="2">우유</label>
					<input id = "게" name="allergy" value="3" type="checkbox"><label for="3">게</label>
					<input id = "새우" name="allergy" value="4" type="checkbox"><label for="4">새우</label>
					<input id = "참치" name="allergy" value="5" type="checkbox"><label for="5">참치</label>
					<input id = "연어" name="allergy" value="6" type="checkbox"><label for="6">연어</label>
					<input id = "쑥" name="allergy" value="7" type="checkbox"><label for="7">쑥</label>
					<input id = "소고기" name="allergy" value="8" type="checkbox"><label for="8">소고기</label>
					<input id = "닭고기" name="allergy" value="9" type="checkbox"><label for="9">닭고기</label>
					<input id = "돼지고기" name="allergy" value="10" type="checkbox"><label for="10">돼지고기</label>
					<input id = "복숭아" name="allergy" value="11" type="checkbox"><label for="11">복숭아</label>
					<input id = "민들레" name="allergy" value="12" type="checkbox"><label for="12">민들레</label>
					<input id = "계란흰자" name="allergy" value="13" type="checkbox"><label for="13">계란흰자</label>
				</div>
			</div>	
			<div class="form-group" id="login_buttons">
				<div style="height: 10px"></div>
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-1">
						<button type="button" onclick="updatemember()"  class="btn btn-default mybutton" id="update">정보수정</button>
					</div>
					<div class="col-sm-1">
						<button type="button" onclick="deletemember()" class="btn btn-default mybutton" id="delete">회원탈퇴</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function updatemember(){
	  	console.log("업데이트할까?");
		let $form = $("#fm");
		$form.attr("action","update.do");
		$form.submit();
	}

	function deletemember(){
		let $form = $("#fm");
		$form.attr("action","delete.do");
		$form.submit();
	}
	
	function setAllergy(){
		let temp = '${member.allergy}';
		console.log(temp);
		let split_temp = temp.split('/');
		console.log(split_temp);
		
		for ( var i in split_temp ) {
			console.log(split_temp[i]);
			
			$("#" + split_temp[i]).attr("checked", true);
	    }
	}
	
	setAllergy();
</script>
</html>
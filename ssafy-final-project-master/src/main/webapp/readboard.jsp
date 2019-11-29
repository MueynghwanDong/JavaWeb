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

			<form role="form" action="readboard.do" method="post">

				<input type='hidden' name='bno' value="${board.bno}">
				<input type='hidden' name='page' value="${cri.page}">
				<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
				<input type='hidden' name='searchType' value="${cri.searchType}">
				<input type='hidden' name='keyword' value="${cri.keyword}">

			</form>

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
			<div class="box-footer">

				<div>
					<hr>
				</div>

				<ul class="mailbox-attachments clearfix uploadedList">
				</ul>
				<c:if test="${member.name == board.writer}">
					<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
					<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
				</c:if>
				<button type="submit" class="btn btn-primary" id="goListBtn">GO LIST</button>
			</div>





			<!-- 				<div class="box box-success"> -->
			<h3 class="box-title">ADD NEW REPLY</h3>


			<div class="box-footer">
				<c:if test="${not empty member}">

					<label for="exampleInputEmail1">Writer</label>
					<input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter"
						value="${member.name }" readonly="readonly">
					<label for="exampleInputEmail1">Reply Text</label>
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">


					<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
				</c:if>
				</div>
				<div class ="box-footer">
				<c:if test="${empty member}">
					<div>
						<a href="login.jsp">Login Please</a>
					</div>
				</c:if>
			</div>

			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="repliesDiv"><span class="bg-green"> Replies List <small
						id='replycntSmall'> [ ${board.replycnt} ] </small>
				</span></li>
			</ul>

			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>
		</div>
	</div>




	<!-- Modal -->
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-rno>
					<p>
						<input type="text" id="replytext" class="form-control">
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>



	<!-- /.content -->

	<jsp:include page="footer.jsp"></jsp:include>

</body>


<script id="template" type="text/x-handlebars-template">
				{{#each .}}
	         <li class="replyLi" data-rno={{rno}}>
             <i class="fa fa-comments bg-blue"></i>
             <div class="timeline-item" >
                <span class="time">
                  <i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
                </span>
                <h3 class="timeline-header"><strong>{{rno}}</strong> -{{replyer}}</h3>
                <div class="timeline-body">{{replytext}} </div>
								<div class="timeline-footer">
								{{#eqReplyer replyer }}
                  <a class="btn btn-primary btn-xs" 
									data-toggle="modal" data-target="#modifyModal">Modify</a>
								{{/eqReplyer}}
							  </div>
	            </div>			
           </li>
        {{/each}}
</script>

<script>
let bno = ${board.bno};
console.log(bno);
	function goLogin() {
		self.location = "login.jsp";
	}

// 	Handlebars.registerHelper("eqReplyer", function(replyer, block) {
// 		var accum = '';
// 		if (replyer == '${login.uid}') {
// 			accum += block.fn();
// 		}
// 		return accum;
// 	});

// 	Handlebars.registerHelper("prettifyDate", function(timeValue) {
// 		var dateObj = new Date(timeValue);
// 		var year = dateObj.getFullYear();
// 		var month = dateObj.getMonth() + 1;
// 		var date = dateObj.getDate();
// 		return year + "/" + month + "/" + date;
// 	});

	var printData = function(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);

	}


	var replyPage = 1;

	function getPage(pageInfo) {

		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#repliesDiv"), $('#template'));
			printPaging(data.pageMaker, $(".pagination"));

			$("#modifyModal").modal('hide');
			$("#replycntSmall").html("[ " + data.pageMaker.totalCount + " ]");

		});
	}

	var printPaging = function(pageMaker, target) {

		var str = "";

		if (pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1)
					+ "'> << </a></li>";
		}

		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}

		if (pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1)
					+ "'> >> </a></li>";
		}

		target.html(str);
	};

	$("#repliesDiv").on("click", function() {

		if ($(".timeline li").size() > 1) {
			return;
		}
		getPage("/replies/" + bno + "/1");

	});

	$(".pagination").on("click", "li a", function(event) {

		event.preventDefault();

		replyPage = $(this).attr("href");

		getPage("/replies/" + bno + "/" + replyPage);

	});

	$("#replyAddBtn").on("click", function() {

		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();

		$.ajax({
			type : 'post',
			url : '/replies/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({
				bno : bno,
				replyer : replyer,
				replytext : replytext
			}),
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("등록 되었습니다.");
					replyPage = 1;
					getPage("/replies/" + bno + "/" + replyPage);
					//replyerObj.val("");
					replytextObj.val("");
				}
			}
		});
	});

	$(".timeline").on("click", ".replyLi", function(event) {

		var reply = $(this);

		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));

	});

	$("#replyModBtn").on("click", function() {

		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'put',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify({
				replytext : replytext
			}),
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("수정 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});

	$("#replyDelBtn").on("click", function() {

		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("삭제 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
</script>


<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$("#modifyBtn").on("click", function() {
			formObj.attr("action", "modify.do");
			formObj.attr("method", "get");
			formObj.submit();
		});

		/* 	$("#removeBtn").on("click", function(){
		 formObj.attr("action", "/sboard/removePage");
		 formObj.submit();
		 }); */

		$("#removeBtn").on("click", function() {

			var replyCnt = $("#replycntSmall").html();

			if (replyCnt > 0) {
				alert("댓글이 달린 게시물을 삭제할 수 없습니다.");
				return;
			}

		});

		$("#goListBtn ").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "board.do");
			formObj.submit();
		});

	});

	
</script>
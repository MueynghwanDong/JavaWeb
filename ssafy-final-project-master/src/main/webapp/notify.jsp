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
<script>
let productlist = () => {
        $.ajax({
            url:"foodlist.do",
            type:"post",
            data:$("#my_form").serialize(),
            success:()=>{
//            	("성공");
            },
            error:()=>{
                alert("아이쿠");
            }
        })
}

</script>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="detail">
		<div id="result" class="container">
			<h2 class="high_light middle">
				<b>공지사항</b>
			</h2>
			<hr>
			<div class='box-body'>

				<select name="searchType">
					<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
					<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>Title</option>
					<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>Content</option>
					<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>Writer</option>
				</select>
				<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
				<button id='searchBtn'>Search</button>
			</div>

			<table class="table">
				<tr>
					<td><span class="high_light">번호</span></td>
					<td><span class="high_light">제목</span></td>
					<td><span class="high_light">내용</span></td>
					<td><span class="high_light">작성자</span></td>
					<td><span class="high_light">작성일자</span></td>
					<td><span class="high_light">조회수</span></td>
				</tr>
				<c:forEach items="${boards}" var="board">
					<tr>
						<td><a class="none_deco" href="modify.do?bno=${board.bno }">${board.bno}</a></td>
						<td><a class="none_deco" href="modify.do?bno=${board.bno }">${board.title}</a></td>
						<td><a class="none_deco" href="modify.do?bno=${board.bno }">${board.content}</a></td>
						<td><p>${board.writer}</p></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}" /></td>
						<td><p>${board.viewcnt}</p></td>

					</tr>
				</c:forEach>

			</table>
			<c:if test="${not empty member}">

				<a href=register.do>글쓰기</a>
			</c:if>
			<!-- 				<input type="button" class="btn btn-default" value="글쓰기"  /> -->
			<hr>
		</div>
	</div>
	<div class="box-footer">

		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a href="notify${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>><a
						href="board.do${pageMaker.makeSearch(idx)}">${idx}</a></li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a href="notify${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>

			</ul>
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
	$(document).ready(
			function() {
				
				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "boardlist.do?"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

			});
</script>

<script src="search.js"></script>
</html>

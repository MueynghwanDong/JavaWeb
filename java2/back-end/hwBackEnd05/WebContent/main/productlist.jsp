<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<c:if test="${sessionScope.Delete != null }">
		상품을 삭제했습니다.
		<c:remove var="Delete" scope="session" />
	</c:if>

	<c:if test="${sessionScope.Update != null }">
		상품이 변경됬습니다.
		<c:remove var="Update" scope="session" />
	</c:if>
	<table>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품설명</th>
		</tr>
		<c:forEach items="${sessionScope.products }" var="product">
			<tr>
				<td>${product.number }</td>
				<td><a href="#" id="pname">${product.name }</a></td>
				<td>${product.price }</td>
				<td>${product.info }</td>
			</tr>
		</c:forEach>
		<tbody id="data-container">
			<!--  데이터 처리 -->

		</tbody>
	</table>
	<h1></h1>
	<a href="updateproduct.jsp">상품 수정</a>
	<a href="deleteproduct.jsp">상품 삭제</a>
	<a href="../productlist.do">상품 목록</a>
	<a href="../main.jsp">메인으로</a>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).on("mouseover", "#pname", function(e){   
    let s= $("#pname").text();
    console.log(e.target.innerText);
    $.ajax({
       url:"test.do",
       method:"post",
       data:"name="+e.target.innerText,
       success:function(resTxt){
          console.log(resTxt.name);
          $("#data-container").empty();
          let $tr = $("<tr>");
          $tr.append("<td>"+resTxt.number+"</td>");
          $tr.append("<td>"+resTxt.name+"</td>");
          $tr.append("<td>"+resTxt.price+"</td>");
          $tr.append("<td>"+resTxt.info+"</td>");
          $("#data-container").append($tr);
       },
       error:function(){
          alert("오류");
       }
    });
    
 });
 $(document).on("mouseout", "#pname", function(){
    $("#data-container").empty();
 });
     
     
     </script>
</html>
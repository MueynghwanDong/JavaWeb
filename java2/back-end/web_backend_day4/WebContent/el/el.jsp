<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int result = 0; // 로컬변수
		for (int i = 1; i < 10; i++) {
			result += 1;
		}
		request.setAttribute("res", result); // request 영역에 저장
		session.setAttribute("res", result*100);
		request.setAttribute("name", "홍길동"); 
	%>

	<h1>여러 값의 활용</h1>
	<ul>
		<li><%=result%>							<%-- 로컬 변수 접근  --%> 
		<li><%=request.getAttribute("res") %>	<%-- 속성 접근 --%>
		<%-- ${출력하고 싶은 내용 작성} --%>
		<li>${res}							 	<%-- EL로 속성 접근 --%>
		<%-- EL은 값을 가져올 때 page - request - session - application 순으로 찾아보고 처음 발견된 값을 리턴 --%>
		<%-- 특정 scope에 저장된 값을 가져오려면..  --%>
		<%--pageScope, requestScope, sessionScope, applicationScope --%>
		<li>${sessionScope.res }
		
	</ul>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$("li").on("click", function(){
	//alert("hello" + <%=result%>); // javascript에서 EL, scriptlet 사용은 문제 없음.
	//alert("hello" + ${res}); // 변환 과정에서 값으로 대체
	alert("${name}"); //HTML 에서 어떤 모습인지 생각해보자!!
})
</script>
</html>
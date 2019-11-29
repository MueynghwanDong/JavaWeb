<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		.middle {
			text-align: center;
		}

		.right {
			text-align: right;
		}

		.bg-silver {
			background: silver;
		}

		table td {
			border: 1px solid;
		}

		div {
			border: 1px solid;
			text-align: center;
			width: 300px;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h2>도서 등록 화면</h2>
<jsp:include page ="userinfo.jsp"></jsp:include>
<br>
		
<form method="post" action="addServlet">
<table>
	
		

	<tbody>
		<tr>
			<td colspan="2">
				* 표시가 된 항목은 필수 입력 항목입니다.
			</td>
		
		</tr>
		<tr>
			<td>
				* 도서번호
			</td>
			<td>
				<input type="text" name ="isbn1"id ="isbn1" />
			</td>
		</tr>
		<tr>
			<td>
				* 도서제목
			</td>
			<td>
				<input type="text" name = "title" id ="title"/>
			</td>
		</tr>		
		<tr>
			<td>
				 출판사
			</td>
			<td>
				<select name ="publisher" id ="publisher">
					<option value="cyber">사이버출판사</option>
					<option value="s">출판사</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				* 저자
			</td>
			<td>
				<input type="text" name="author" id ="author" />
			</td>
		</tr>
		<tr>
			<td>
				 도서가격
			</td>
			<td>
				<input type="text" name ="price" id ="price"/>
			</td>
		</tr>
		<tr>
			<td>
				 요약내용
			</td>
			<td>
				<textarea cols="40" rows="5" name="description" id ="description"></textarea>
			</td>
		</tr>
	</tbody>

	<tfoot>
		<tr>
			<td colspan="2">
				<input type="submit" value="도서등록"/>
				<input type="reset" value="취소"/>
			</td>
		</tr>
	</tfoot>
</table>
</form>
</body>
</html>
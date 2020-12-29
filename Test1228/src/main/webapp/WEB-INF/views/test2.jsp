<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>test.jsp</h2>
	<h2>링크타고오기 성공</h2>

	<h2>첫번째 : ${pa1}</h2>
	<h2>첫번째 : ${pa2}</h2>

	<a href="./">홈으로가기</a>
	
	<form action="insert" method="post">
	DB에 저장할 데이터 : <input type="text" name="data1"> <br>
	<input type="submit" value="DB저장">
	</form>
	
	
</body>
</html>
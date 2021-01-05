<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
a{
text-decoration: none;
font-size: 20px;
font-weight: bold;
color: gray;
}
a:visited{
	color: gray;
}
a:hover{
color: lightgray;
}
table, tr, td ,th{
	text-align: center;
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}
body {
	text-align: center;
}
</style>
<body>
<table>
<tr> <th> 글번호 </th>  <th> 제목  </th> <th> 작성자 </th> <th>작성일자 </th> <th> 조회수 </th> <th> 삭제 </th> </tr>
	<c:forEach var="i" items="${list}">
	<tr> <td> ${i.bnum} </td> <td> <a href="boardDetail?bnum=${i.bnum}">${i.btitle}</a>  </td> <td> ${i.bwriter} </td> <td> ${i.bdate} </td> <td> ${i.bhits} </td> <td> <a href="BoardDelete?bnum=${i.bnum}">삭제</a> </td> </tr>
	</c:forEach>
</table>
<br>
<a href="./">메인으로</a>
</body>
</html>














